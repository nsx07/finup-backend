package syncronzr.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import syncronzr.api.entity.Service;
import syncronzr.api.entity.User;
import syncronzr.api.services.ServiceService;
import syncronzr.api.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceController {

    @Autowired
    private ServiceService _serviceService;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public List<Service> Get() {

        return _serviceService.get();
    }

    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
    public ResponseEntity<Service> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Service> service = _serviceService.getById(id);
        if(service.isPresent())
            return new ResponseEntity<Service>(service.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/service", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody Service service)
    {
        return _serviceService.save(service);
    }

    @RequestMapping(value = "/service", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody Service service)
    {
        return _serviceService.update(service.getId(), service);
    }

}

