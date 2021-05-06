package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TshirtController {

    @Autowired
    ServiceLayer service;

    @GetMapping(value = "/tshirt")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getAllTshirts() {
        List<Tshirt> tshirts = service.getAllTshirts();
        return tshirts;
    }

    @RequestMapping(value = "/tshirtColor/(color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String color) {
        return service.getTshirtByColor(color);
    }

    @RequestMapping(value = "/tshirtSize/(color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String size) {
        return service.getTshirtBySize(size);
    }

    @RequestMapping(value = "/tshirt/(id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable int id) {
        return service.getTshirt(id);
    }

    @PostMapping(value = "/tshirt")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody Tshirt tshirt) {
        return service.addTshirt(tshirt);
    }

    @PutMapping(value = "/tshirt/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTshirt(@PathVariable int id, @RequestBody Tshirt tshirt) {
        tshirt.setId(id);
        service.updateTshirt(tshirt);
    }

    @DeleteMapping(value = "/tshirt/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id) {
        service.deleteTshirt(id);
    }
}
