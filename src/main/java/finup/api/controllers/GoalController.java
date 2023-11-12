package finup.api.controllers;

import finup.api.entity.Goal;
import finup.api.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController(value = "api/goal")
public class GoalController {

    @Autowired
    private GoalService _goalService;

    @RequestMapping(value = "api/goal/getAll", method = RequestMethod.GET)
    public List<Goal> Get() {
        return _goalService.get();
    }

    @RequestMapping(value = "api/goal/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Goal> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<Goal> goal = _goalService.getById(id);
        if(goal.isPresent())
            return new ResponseEntity<Goal>(goal.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "api/goal/save", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody Goal goal)
    {
        return _goalService.save(goal);
    }

    @RequestMapping(value = "api/goal/update", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody Goal goal)
    {
        return _goalService.update(goal.getId(), goal);
    }

    @RequestMapping(value = "api/goal/delete/{id}", method =  RequestMethod.DELETE)
    public Boolean Delete(@PathVariable(value = "id") Long id)
    {
        return _goalService.delete(id);
    }

}
