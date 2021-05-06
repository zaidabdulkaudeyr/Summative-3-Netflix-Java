package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.TshirtDao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TshirtController {

    @Autowired
    TshirtDao tshirtDao;

    public TshirtController(TshirtDao dao){this.tshirtDao = tshirtDao;}

    //get all tshirts
    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getAllTshirt(){
        System.out.println("Getting all tshirts...");
        return tshirtDao.getAllTshirts();
    }

    //get by color
    @RequestMapping(value = "/tshirtColor/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String color) {
        return tshirtDao.getTshirtByColor(color);
    }

    //get by size
    @RequestMapping(value = "/tshirtSize/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String size) {
        return tshirtDao.getTshirtBySize(size);
    }

    //get by id
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable int id) {
        return tshirtDao.getTshirt(id);
    }

    //add tshirt
    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody Tshirt tshirt) {
        System.out.println("creating tshirt");
        return tshirtDao.addTshirt(tshirt);
    }

    //update tshirt
    @RequestMapping(value = "/tshirt", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody Tshirt tshirt){
        System.out.println("Updating Tshirt id = " + tshirt.getId());
        tshirtDao.updateTshirt(tshirt);
    }

    //delete tshirt
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id) {
        System.out.println("Tshirt deleted");
        tshirtDao.deleteTshirt(id);
    }
}
