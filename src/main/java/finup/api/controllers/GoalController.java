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
@RestController(value = "goal")
public class GoalController {

    @Autowired
    private GoalService _goalService;

    @RequestMapping(value = "goal/getAll", method = RequestMethod.GET)
    public List<Goal> Get() {
        return _goalService.get();
    }

    @RequestMapping(value = "goal/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Goal> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<Goal> goal = _goalService.getById(id);
        if(goal.isPresent())
            return new ResponseEntity<Goal>(goal.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "goal/save", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody Goal goal)
    {
        return _goalService.save(goal);
    }

    @RequestMapping(value = "goal/update", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody Goal goal)
    {
        return _goalService.update(goal.getId(), goal);
    }

}
