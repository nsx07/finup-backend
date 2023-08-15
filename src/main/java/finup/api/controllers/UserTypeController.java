package finup.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import finup.api.entity.User;
import finup.api.entity.UserType;
import finup.api.services.UserService;
import finup.api.services.UserTypeService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserTypeController {

    @Autowired
    private UserTypeService _userTypeService;

    @RequestMapping(value = "/userType", method = RequestMethod.GET)
    public List<UserType> Get() {

        return _userTypeService.get();
    }

    @RequestMapping(value = "/userType/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserType> GetById(@PathVariable(value = "id") long id)
    {
        Optional<UserType> userType = _userTypeService.getById(id);
        if(userType.isPresent())
            return new ResponseEntity<UserType>(userType.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/userType", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody UserType userType)
    {
        return _userTypeService.save(userType);
    }

    @RequestMapping(value = "/userType", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody UserType userType)
    {
        return _userTypeService.update(userType.getId(), userType);
    }

}

