package syncronzr.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import syncronzr.api.entity.Schedule;
import syncronzr.api.entity.User;
import syncronzr.api.services.ScheduleService;
import syncronzr.api.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService _scheduleService;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public List<Schedule> Get() {

        return _scheduleService.get();
    }

    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.GET)
    public ResponseEntity<Schedule> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Schedule> schedule = _scheduleService.getById(id);
        if(schedule.isPresent())
            return new ResponseEntity<Schedule>(schedule.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/schedule", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody Schedule schedule)
    {
        return _scheduleService.save(schedule);
    }

    @RequestMapping(value = "/schedule", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody Schedule schedule)
    {
        return _scheduleService.update(schedule.getId(), schedule);
    }

}

