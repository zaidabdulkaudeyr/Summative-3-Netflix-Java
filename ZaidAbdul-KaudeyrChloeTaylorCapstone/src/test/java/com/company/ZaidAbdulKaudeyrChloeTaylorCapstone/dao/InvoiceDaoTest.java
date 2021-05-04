package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception{
        // Clean up the test database
        List<Invoice> dList = invoiceDao.getAllInvoices();
        for (Invoice d : dList){
            invoiceDao.deleteInvoice(d.getId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {
        //Arrange
        Invoice invoice = new Invoice();
        invoice.setName("Amanda");
        invoice.setStreet("12345 Presidential Lane");
        invoice.setCity("Norfolk");
        invoice.setState("VA");
        invoice.setZipcode("23407");
        invoice.setItemType("Console");


    }

    @Test
    public void getAllInvoices() {
    }
}