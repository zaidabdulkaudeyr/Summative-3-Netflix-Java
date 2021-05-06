package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.ConsoleDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleDao consoleDao;

    @GetMapping(value = "/console")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        List<Console> consoles = consoleDao.getAllConsoles();
        return consoles;
    }

    @RequestMapping(value = "/consoleMan/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer){
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable int id) {
        return consoleDao.getConsole(id);
    }

    @PostMapping(value = "/console")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console) {
        consoleDao.addConsole(console);
        return console;
    }

    @PutMapping(value = "/console/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable int id, @RequestBody Console console) {
        console.setId(id);
        consoleDao.updateConsole(console);
    }

    @DeleteMapping(value = "/console/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        consoleDao.deleteConsole(id);
    }
}
