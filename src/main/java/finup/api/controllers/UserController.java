package finup.api.controllers;

import finup.api.entity.User;
import finup.api.repository.UserRepository;
import finup.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "user")
public class UserController {

    @Autowired
    private UserService _userService;

    @RequestMapping(value = "user/getAll", method = RequestMethod.GET)
    public List<User> Get() {
        return _userService.get();
    }

    @RequestMapping(value = "user/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<User> user = _userService.getById(id);
        if(user.isPresent())
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "user/save", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody User user)
    {
        return _userService.save(user);
    }

    @RequestMapping(value = "user/update", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody User user)
    {
        return _userService.update(user.getId(), user);
    }

    @RequestMapping(value="user/delete/{id}", method = RequestMethod.DELETE)
    public boolean Delete(@PathVariable(value = "id") Long id)
    {
        return _userService.delete(id);
    }

}
