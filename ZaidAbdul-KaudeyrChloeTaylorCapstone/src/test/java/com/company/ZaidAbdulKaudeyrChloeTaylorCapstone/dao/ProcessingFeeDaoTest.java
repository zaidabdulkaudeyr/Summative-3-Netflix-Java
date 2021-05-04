package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.ProcessingFee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Test
    public void getProcessingFeeByType() {

        //Arrange
        ProcessingFee processingFee = new ProcessingFee();
        ProcessingFee processingFee2 = new ProcessingFee();
        ProcessingFee processingFee3 = new ProcessingFee();

        processingFee = processingFeeDao.getProcessingFeeByType("Consoles");
        processingFee2 = processingFeeDao.getProcessingFeeByType("T-Shirts");
        processingFee3 = processingFeeDao.getProcessingFeeByType("Games");

        //Assert
        assertEquals(processingFee.getFee(), new BigDecimal("14.99"));
        assertEquals(processingFee2.getFee(), new BigDecimal("1.98"));
        assertEquals(processingFee3.getFee(), new BigDecimal("1.49"));
    }
}