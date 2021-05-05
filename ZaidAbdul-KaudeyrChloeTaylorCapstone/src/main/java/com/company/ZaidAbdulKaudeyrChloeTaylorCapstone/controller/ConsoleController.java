package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ServiceLayer service;

    @GetMapping(value = "/console")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        List<Console> consoles = service.getAllConsoles();
        return consoles;
    }

    @RequestMapping(value = "/consoleMan/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer){
        return service.getConsolesByManufacturer(manufacturer);
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable int id) {
        return service.getConsole(id);
    }

    @PostMapping(value = "/console")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console) {
        service.addConsole(console);
        return console;
    }

    @PutMapping(value = "/console/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable int id, @RequestBody Console console) {
        //console = service.getConsole(id);
        console = service.getConsole(id);
        service.updateConsole(console);
    }

    @DeleteMapping(value = "/console/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        service.deleteConsole(id);
    }
}
