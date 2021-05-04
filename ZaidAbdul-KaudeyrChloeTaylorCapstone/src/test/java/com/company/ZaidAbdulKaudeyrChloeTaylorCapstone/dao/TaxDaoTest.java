package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tax;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaxDaoTest {

    @Autowired
    TaxDao taxDao;

    @Test
    public void getTaxByState() {

        //Arrange
        Tax tax = new Tax();
        Tax tax2 = new Tax();
        Tax tax3 = new Tax();

        tax = taxDao.getTaxByState("VA");
        tax2 = taxDao.getTaxByState("NC");
        tax3 = taxDao.getTaxByState("OK");

        //Assert
        assertEquals(tax.getRate(), new BigDecimal(".06"));
        assertEquals(tax2.getRate(), new BigDecimal(".05"));
        assertEquals(tax3.getRate(), new BigDecimal(".04"));
    }
}