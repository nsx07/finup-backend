package finup.api.controllers;

import finup.api.entity.Bill;
import finup.api.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "bill")
public class BillController {

    @Autowired
    private BillService _billService;

    @RequestMapping(value = "bill/getAll", method = RequestMethod.GET)
    public List<Bill> Get() {
        return _billService.get();
    }

    @RequestMapping(value = "bill/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bill> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<Bill> bill = _billService.getById(id);
        if(bill.isPresent())
            return new ResponseEntity<Bill>(bill.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "bill/save", method =  RequestMethod.POST)
    public Boolean Post(@Validated @RequestBody Bill bill)
    {
        return _billService.save(bill);
    }

    @RequestMapping(value = "bill/update", method =  RequestMethod.PUT)
    public Boolean Put(@Validated @RequestBody Bill bill)
    {
        return _billService.update(bill.getId(), bill);
    }

    @RequestMapping(value = "bill/delete/{id}", method =  RequestMethod.DELETE)
    public Boolean Delete(@PathVariable(value = "id") Long id)
    {
        return _billService.delete(id);
    }

}