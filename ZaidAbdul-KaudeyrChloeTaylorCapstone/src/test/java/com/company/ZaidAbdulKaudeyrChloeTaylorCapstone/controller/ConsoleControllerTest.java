package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.ConsoleDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)

public class ConsoleControllerTest {

    @Autowired
    ConsoleDao consoleDao;
    public MockMvc mockMvc;

    // object mapper used to convert java objects to json and vise versa
    public ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception{
        // Clean up the test database
        List<Console> dList = consoleDao.getAllConsoles();
        for (Console d : dList){
            consoleDao.deleteConsole(d.getId());
        }
    }

    @Test
    public void getAllConsoles() throws Exception{
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        String outputJson = mapper.writeValueAsString(console);

        mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsolesByManufacturer() {
    }

    @Test
    public void getConsole() {
    }

    @Test
    public void createConsole() {
    }

    @Test
    public void updateConsole() {
    }

    @Test
    public void deleteConsole() {
    }
}