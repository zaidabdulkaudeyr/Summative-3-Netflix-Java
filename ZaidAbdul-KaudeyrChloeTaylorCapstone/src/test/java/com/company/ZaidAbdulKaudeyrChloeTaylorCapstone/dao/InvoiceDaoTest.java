package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
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
        invoice.setItemType("Console"); //User puts this in need error handling
        invoice.setItemId(1); //User puts this in need error handling
        invoice.setUnitPrice(new BigDecimal("299.00")); //Found in service layer
        invoice.setQuantity(1); //User puts this in need error handling
        invoice.setSubtotal(new BigDecimal("304.99")); //Calculated in service layer
        invoice.setTax(new BigDecimal(".06")); //Found in service Layer
        invoice.setProcessingFee(new BigDecimal("14.99")); //Found in service layer
        invoice.setTotal(new BigDecimal("316.00")); //Found in service layer

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getId());

        //Assert
        assertEquals(invoice1, invoice);

        invoiceDao.deleteInvoice(invoice.getId());
        invoice1 = invoiceDao.getInvoice(invoice.getId());

        //Assert
        assertNull(invoice1);
    }

    @Test
    public void getAllInvoices() {

        //First invoice
        Invoice invoice = new Invoice();
        invoice.setName("Amanda");
        invoice.setStreet("12345 Presidential Lane");
        invoice.setCity("Norfolk");
        invoice.setState("VA");
        invoice.setZipcode("23407");
        invoice.setItemType("Console");
        invoice.setItemId(1); //Found in service layer
        invoice.setUnitPrice(new BigDecimal("299.00")); //Found in service layer
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("304.99")); //Calculated in service layer
        invoice.setTax(new BigDecimal(".06")); //Found in service Layer
        invoice.setProcessingFee(new BigDecimal("14.99")); //Found in service layer
        invoice.setTotal(new BigDecimal("316.00")); //Found in service layer

        invoice = invoiceDao.addInvoice(invoice);

        //Second invoice
        Invoice invoice1 = new Invoice();
        invoice1.setName("Amanda");
        invoice1.setStreet("12345 Presidential Lane");
        invoice1.setCity("Norfolk");
        invoice1.setState("VA");
        invoice1.setZipcode("23407");
        invoice1.setItemType("Console");
        invoice1.setItemId(1); //Found in service layer
        invoice1.setUnitPrice(new BigDecimal("299.00")); //Found in service layer
        invoice1.setQuantity(1);
        invoice1.setSubtotal(new BigDecimal("304.99")); //Calculated in service layer
        invoice1.setTax(new BigDecimal(".06")); //Found in service Layer
        invoice1.setProcessingFee(new BigDecimal("14.99")); //Found in service layer
        invoice1.setTotal(new BigDecimal("316.00")); //Found in service layer

        invoice1 = invoiceDao.addInvoice(invoice1);

        List<Invoice> bList = invoiceDao.getAllInvoices();

        assertEquals(bList.size(), 2);
    }
}