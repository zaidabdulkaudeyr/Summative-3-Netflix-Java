package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.ConsoleDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.TshirtDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ConsoleControllerTest {

    // wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // object mapper used to convert java objects to json and vise versa
    public ObjectMapper mapper = new ObjectMapper();

    //list for testing
    @MockBean
    ConsoleDao consoleDao;


    // Testing GET
    @Test
    public void getAllConsoles() throws Exception{
    // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(consoleDao.getAllConsoles());
        // ACT
        mockMvc.perform(get("/console"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    //testing get by manufacturer
    @Test
    public void getConsolesByManufacturer() throws Exception{
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        String outputJson = mapper.writeValueAsString(console);

        mockMvc.perform(get("/consoleMan/Nintendo"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //get by id testing
    @Test
    public void getConsole() throws Exception {
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        String outputJson = mapper.writeValueAsString(console);

        mockMvc.perform(get("/console/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //testing create
    @Test
    public void createConsole() throws Exception {
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        String inputJson = mapper.writeValueAsString(console);

        Console outputConsole = new Console();
        outputConsole.setModel("Switch");
        outputConsole.setManufacturer("Nintendo");
        outputConsole.setMemoryAmount("32GB");
        outputConsole.setProcessor("Intel");
        outputConsole.setPrice(new BigDecimal("299.00"));
        outputConsole.setQuantity(3);

        String outputJson = mapper.writeValueAsString(outputConsole);

        //Act
        mockMvc.perform(
                post("/console")                            // Perform the POST request
                        .content(inputJson)                       // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
        )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }
    //update testing
    @Test
    public void updateConsole() throws Exception {
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        //convert Java object to JSON
        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(
                put("/console")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteConsole() throws Exception {
        mockMvc.perform(delete("/console/2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}