package syncronzr.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import syncronzr.api.entity.ServiceType;
import syncronzr.api.entity.User;
import syncronzr.api.services.ServiceTypeService;
import syncronzr.api.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService _serviceTypeService;

    @RequestMapping(value = "/serviceType", method = RequestMethod.GET)
    public List<ServiceType> Get() {

        return _serviceTypeService.get();
    }

    @RequestMapping(value = "/serviceType/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceType> GetById(@PathVariable(value = "id") long id)
    {
        Optional<ServiceType> serviceType = _serviceTypeService.getById(id);
        if(serviceType.isPresent())
            return new ResponseEntity<ServiceType>(serviceType.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/serviceType", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody ServiceType serviceType)
    {
        return _serviceTypeService.save(serviceType);
    }

    @RequestMapping(value = "/serviceType", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody ServiceType serviceType)
    {
        return _serviceTypeService.update(serviceType.getId(), serviceType);
    }

}

