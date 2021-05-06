package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.ConsoleDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleDao consoleDao;

    //get all
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        System.out.println("Getting all consoles...");
        return consoleDao.getAllConsoles();
    }

    //get by manufacturer
    @RequestMapping(value = "/consoleMan/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer){
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }

    //get by id
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable int id) {
        return consoleDao.getConsole(id);
    }

    //add console
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console) {
        System.out.println("creating console");
        return consoleDao.addConsole(console);
    }

    //update console
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {
        System.out.println("Updating console id = " + console.getId());
        consoleDao.updateConsole(console);
    }

    //delete console
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        System.out.println("console deleted");
        consoleDao.deleteConsole(id);
    }
}
