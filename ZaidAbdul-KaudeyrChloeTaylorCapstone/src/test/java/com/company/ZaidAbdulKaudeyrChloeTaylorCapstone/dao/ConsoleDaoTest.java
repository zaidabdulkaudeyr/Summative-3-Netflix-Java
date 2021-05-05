package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import org.junit.Before;
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
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;


    @Before
    public void setUp() throws Exception{
        // Clean up the test database
        List<Console> dList = consoleDao.getAllConsoles();
        for (Console d : dList){
            consoleDao.deleteConsole(d.getId());
        }
    }

    @Test
    public void addGetDeleteConsole() {
        //Arrange
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        //Assert
        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getId());
        console1 = consoleDao.getConsole(console.getId());

        //Assert
        assertNull(console1);

    }

    @Test
    public void getAllConsoles() {

        //First console
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        //Second console
        Console console1 = new Console();
        console1.setModel("Play Station 5");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("825GB");
        console1.setProcessor("Intel");
        console1.setPrice(new BigDecimal("500.00"));
        console1.setQuantity(3);

        console1 = consoleDao.addConsole(console1);

        List<Console> bList = consoleDao.getAllConsoles();

        assertEquals(bList.size(), 2);
    }

    @Test
    public void getConsolesByManufacturer() {

        //First console
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        //Second console
        Console console1 = new Console();
        console1.setModel("Play Station 5");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("825GB");
        console1.setProcessor("Intel");
        console1.setPrice(new BigDecimal("500.00"));
        console1.setQuantity(3);

        console1 = consoleDao.addConsole(console1);

        List<Console> bList = consoleDao.getConsolesByManufacturer("Nintendo");

        //Assert
        assertEquals(bList.size(), 1);
    }

    @Test
    public void updateConsole() {

        //add console
        Console console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(3);

        console = consoleDao.addConsole(console);

        console.setModel("Switch Lite");
        console.setMemoryAmount("16GB");
        console.setQuantity(5);

        //updates console
        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());
        assertEquals(console1, console);
    }
}