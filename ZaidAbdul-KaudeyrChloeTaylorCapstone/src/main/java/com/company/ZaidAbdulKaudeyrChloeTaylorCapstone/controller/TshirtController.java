package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.TshirtDao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TshirtController {



    //@Autowired
    //ServiceLayer service;
    @Autowired
    TshirtDao tshirtDao;
    public TshirtController(TshirtDao dao){this.tshirtDao = tshirtDao;}

    //@GetMapping(value = "/tshirt")
    //@ResponseStatus(value = HttpStatus.OK)
    //public List<Tshirt> getAllTshirts() {
    //    List<Tshirt> tshirts = tshirt.getAllTshirts();
    //    return tshirts;
    //}

    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getAllTshirt(){
        System.out.println("Getting all tshirts...");
        return tshirtDao.getAllTshirts();
    }

    @RequestMapping(value = "/tshirtColor/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String color) {
        return tshirtDao.getTshirtByColor(color);
    }

    @RequestMapping(value = "/tshirtSize/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String size) {
        return tshirtDao.getTshirtBySize(size);
    }

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable int id) {
        return tshirtDao.getTshirt(id);
    }

    @PostMapping(value = "/tshirt")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody Tshirt tshirt) {
        System.out.println("creating tshirt");
        return tshirtDao.addTshirt(tshirt);
    }

    @PutMapping(value = "/tshirt/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTshirt(@PathVariable int id, @RequestBody Tshirt tshirt) {
        tshirt.setId(id);
        tshirtDao.updateTshirt(tshirt);
    }

    @DeleteMapping(value = "/tshirt/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id) {
        tshirtDao.deleteTshirt(id);
    }
}
