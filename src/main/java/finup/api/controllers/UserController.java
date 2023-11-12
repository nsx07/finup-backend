package finup.api.controllers;

import finup.api.entity.User;
import finup.api.repository.UserRepository;
import finup.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "api/user")
public class UserController {

    @Autowired
    private UserService _userService;

    @RequestMapping(value = "api/user/getAll", method = RequestMethod.GET)
    public List<User> Get() {
        return _userService.get();
    }

    @RequestMapping(value = "api/user/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<User> user = _userService.getById(id);
        if(user.isPresent())
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "api/user/save", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody User user)
    {
        return _userService.save(user);
    }

    @RequestMapping(value = "api/user/update", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody User user)
    {
        return _userService.update(user.getId(), user);
    }

    @RequestMapping(value="api/user/delete/{id}", method = RequestMethod.DELETE)
    public boolean Delete(@PathVariable(value = "id") Long id)
    {
        return _userService.delete(id);
    }

}
