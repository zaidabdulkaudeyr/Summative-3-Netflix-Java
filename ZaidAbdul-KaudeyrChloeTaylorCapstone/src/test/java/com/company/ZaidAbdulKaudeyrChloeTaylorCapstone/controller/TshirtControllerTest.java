package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.TshirtDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TshirtController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TshirtControllerTest {

    // wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vise versa
    private ObjectMapper mapper = new ObjectMapper();

    //list for testing
    @MockBean
    TshirtDao tshirtDao;

    // Testing GET
    @Test
    public void shouldReturnAllTshirts() throws Exception  {
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(tshirtDao.getAllTshirts());
        // ACT
        mockMvc.perform(get("/tshirt"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    public void getTshirtByColor() throws Exception {
        Tshirt outputTshirt = new Tshirt();
        outputTshirt.setSize("M");
        outputTshirt.setColor("pink");
        outputTshirt.setDescription("Very Pretty");
        outputTshirt.setPrice(new BigDecimal("19.99"));
        outputTshirt.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputTshirt);

        mockMvc.perform(get("/tshirtColor/pink"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getTshirtBySize() throws Exception{
        Tshirt outputTshirt = new Tshirt();
        outputTshirt.setSize("M");
        outputTshirt.setColor("pink");
        outputTshirt.setDescription("Very Pretty");
        outputTshirt.setPrice(new BigDecimal("19.99"));
        outputTshirt.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputTshirt);

        mockMvc.perform(get("/tshirtSize/M"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //get by id testing
    @Test
    public void shouldReturnTshirtById() throws Exception{
        Tshirt outputTshirt = new Tshirt();
        outputTshirt.setSize("M");
        outputTshirt.setColor("pink");
        outputTshirt.setDescription("Very Pretty");
        outputTshirt.setPrice(new BigDecimal("19.99"));
        outputTshirt.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputTshirt);

        mockMvc.perform(get("/tshirt/2"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().json(outputJson));
    }

    //add testing
    @Test
    public void shouldReturnNewRecordTshirt() throws Exception{
        // Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("M");
        tshirt.setColor("Pink");
        tshirt.setDescription("Super Soft and Ultra Plush");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(10);

        // Convert Java to JSON
        String inputJson = mapper.writeValueAsString(tshirt);

        Tshirt outputTshirt = new Tshirt();
        outputTshirt.setSize("M");
        outputTshirt.setColor("Pink");
        outputTshirt.setDescription("Super Soft and Ultra Plush");
        outputTshirt.setPrice(new BigDecimal("19.99"));
        outputTshirt.setQuantity(5);
        outputTshirt.setId(10);

        String outputJson = mapper.writeValueAsString(outputTshirt);

        // ACT
        mockMvc.perform(
                post("/tshirt")                            // Perform the POST request
                        .content(inputJson)                       // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    //update testing
    @Test
    public void updateTshirt() throws Exception {

        Tshirt inputTshirt = new Tshirt();
        inputTshirt.setSize("M");
        inputTshirt.setColor("Pink");
        inputTshirt.setDescription("Soft");
        inputTshirt.setQuantity(6);
        inputTshirt.setPrice(new BigDecimal("19.99"));
        //convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputTshirt);
        mockMvc.perform(
                put("/tshirt")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    //delete testing
    @Test
    public void shouldDeleteByIdTshirt() throws Exception {
        mockMvc.perform(delete("/tshirt/2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}