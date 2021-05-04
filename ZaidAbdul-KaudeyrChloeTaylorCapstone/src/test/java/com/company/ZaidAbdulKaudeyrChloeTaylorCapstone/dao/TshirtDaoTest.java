package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtDaoTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception{
        // Clean up the test database
        List<Tshirt> dList = tshirtDao.getAllTshirts();
        for (Tshirt d : dList){
            tshirtDao.deleteTshirt(d.getId());
        }
    }

    @Test
    public void addGetDeleteTshirt() {
        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("M");
        tshirt.setColor("Pink");
        tshirt.setDescription("Super Soft and Ultra Plush");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.getId());

        //Assert
        assertEquals(tshirt1, tshirt);

        tshirtDao.deleteTshirt(tshirt.getId());
        tshirt1 = tshirtDao.getTshirt(tshirt.getId());

        //Assert
        assertNull(tshirt1);
    }

    @Test
    public void getAllTshirts() {

        //First Tshirt
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("M");
        tshirt.setColor("Pink");
        tshirt.setDescription("Super Soft and Ultra Plush");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        //Second Tshirt
        Tshirt tshirt1 = new Tshirt();
        tshirt1.setSize("M");
        tshirt1.setColor("Red");
        tshirt1.setDescription("Durable, Ultra Lightweight, and Extremely Breathable");
        tshirt1.setPrice(new BigDecimal("29.99"));
        tshirt1.setQuantity(5);

        tshirt1 = tshirtDao.addTshirt(tshirt1);

        List<Tshirt> bList = tshirtDao.getAllTshirts();

        assertEquals(bList.size(), 2);
    }

    @Test
    public void getTshirtByColor() {

        //First Tshirt
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("M");
        tshirt.setColor("Pink");
        tshirt.setDescription("Super Soft and Ultra Plush");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        //Second Tshirt
        Tshirt tshirt1 = new Tshirt();
        tshirt1.setSize("M");
        tshirt1.setColor("Red");
        tshirt1.setDescription("Durable, Ultra Lightweight, and Extremely Breathable");
        tshirt1.setPrice(new BigDecimal("29.99"));
        tshirt1.setQuantity(5);

        tshirt1 = tshirtDao.addTshirt(tshirt1);

        List<Tshirt> bList = tshirtDao.getTshirtByColor("Pink");

        assertEquals(bList.size(), 1);

    }

    @Test
    public void getTshirtBySize() {

        //First Tshirt
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("M");
        tshirt.setColor("Pink");
        tshirt.setDescription("Super Soft and Ultra Plush");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        //Second Tshirt
        Tshirt tshirt1 = new Tshirt();
        tshirt1.setSize("M");
        tshirt1.setColor("Red");
        tshirt1.setDescription("Durable, Ultra Lightweight, and Extremely Breathable");
        tshirt1.setPrice(new BigDecimal("29.99"));
        tshirt1.setQuantity(5);

        tshirt1 = tshirtDao.addTshirt(tshirt1);

        List<Tshirt> bList = tshirtDao.getTshirtBySize("M");

        assertEquals(bList.size(), 2);
    }

    @Test
    public void updateTshirt() {

        //First Tshirt
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("M");
        tshirt.setColor("Pink");
        tshirt.setDescription("Super Soft and Ultra Plush");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt.setSize("L");
        tshirt.setColor("Indigo");
        tshirt.setQuantity(2);

        //updates tshirt
        tshirtDao.updateTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.getId());
        assertEquals(tshirt1, tshirt);
    }
}