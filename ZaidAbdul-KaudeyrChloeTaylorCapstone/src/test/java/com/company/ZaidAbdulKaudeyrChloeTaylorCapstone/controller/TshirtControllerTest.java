package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TshirtController.class)
public class TshirtControllerTest {

    // wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vise versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of records for testing purposes
    private List<Tshirt> tshirtList;

    // Testing GET /records
    @Test
    public void shouldReturnAllTshirts() throws Exception  {
        // ARRANGE
        // Convert Java object to JSON

        String outputJson = mapper.writeValueAsString(tshirtList);

        //ACT
        mockMvc.perform(get("/tshirt"))
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    public void getTshirtByColor() {
    }

    @Test
    public void getTshirtBySize() {
    }

    @Test
    public void getTshirt() {
    }

    @Test
    public void addTshirt() {
    }

    @Test
    public void updateTshirt() {
    }
}