package syncronzr.api.controllers;

import syncronzr.api.entity.User;
import syncronzr.api.repository.UserRepository;
import syncronzr.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService _userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> Get() {

        return _userService.get();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> GetById(@PathVariable(value = "id") long id)
    {
        Optional<User> user = _userService.getById(id);
        if(user.isPresent())
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody User user)
    {
        return _userService.save(user);
    }

    @RequestMapping(value = "/user", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody User user)
    {
        return _userService.update(user.getId(), user);
    }

}
