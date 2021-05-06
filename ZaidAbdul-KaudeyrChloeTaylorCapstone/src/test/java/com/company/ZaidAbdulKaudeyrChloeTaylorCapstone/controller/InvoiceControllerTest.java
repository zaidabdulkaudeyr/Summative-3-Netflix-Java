package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.InvoiceDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.TshirtDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Invoice;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service.ServiceLayer;
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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TshirtController.class)
@AutoConfigureMockMvc(addFilters = false)
public class InvoiceControllerTest {

    // wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vise versa
    private ObjectMapper mapper = new ObjectMapper();

    //list for testing
    @MockBean
    ServiceLayer serviceLayer;

    @Test
    public void addInvoice() throws Exception {
        //Arrange
        Invoice invoice = new Invoice();
        invoice.setName("Amanda");
        invoice.setStreet("12345 Presidential Lane");
        invoice.setCity("Norfolk");
        invoice.setState("VA");
        invoice.setZipcode("23407");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("304.99"));
        invoice.setTax(new BigDecimal(".06"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("316.00"));

        // Convert Java to JSON
        String inputJson = mapper.writeValueAsString(invoice);

        Invoice invoice1 = new Invoice();
        invoice1.setName("Amanda");
        invoice1.setStreet("12345 Presidential Lane");
        invoice1.setCity("Norfolk");
        invoice1.setState("VA");
        invoice1.setZipcode("23407");
        invoice1.setItemType("Console");
        invoice1.setItemId(1);
        invoice1.setQuantity(1);
        invoice1.setSubtotal(new BigDecimal("304.99"));
        invoice1.setTax(new BigDecimal(".06"));
        invoice1.setProcessingFee(new BigDecimal("14.99"));
        invoice1.setTotal(new BigDecimal("316.00"));
        invoice1.setId(10);

        String outputJson = mapper.writeValueAsString(invoice1);

        // ACT
        mockMvc.perform(
                post("/invoice")                            // Perform the POST request
                        .content(inputJson)                       // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
        )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)

    }
}