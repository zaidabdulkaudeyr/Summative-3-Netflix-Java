package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.*;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.*;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServiceLayer {
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private TshirtDao tshirtDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private TaxDao taxDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, TshirtDao tshirtDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, TaxDao taxDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tshirtDao = tshirtDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.taxDao = taxDao;
    }

    //
    // console API
    //
    public Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    public Console getConsole(int id) {
        return consoleDao.getConsole(id);
    }

    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }

    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    public void deleteConsole(int id) {
        consoleDao.deleteConsole(id);
    }


    //
    // game API
    //
    public Game addGame(Game game) {
        return gameDao.addGame(game);
    }

    public Game getGame(int id) {
        return gameDao.getGame(id);
    }

    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public List<Game> getGamesByStudio(String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    public List<Game> getGamesByESRB(String esrbRating) {
        return gameDao.getGamesByESRB(esrbRating);
    }

    public List<Game> getGamesByTitle(String title) {
        return gameDao.getGamesByTitle(title);
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public void deleteGame(int id) {
        gameDao.deleteGame(id);
    }


    //
    //Tshirt API
    //
    public Tshirt addTshirt(Tshirt tshirt) {
        return tshirtDao.addTshirt(tshirt);
    }

    public Tshirt getTshirt(int id) {
        return tshirtDao.getTshirt(id);
    }

    public List<Tshirt> getAllTshirts() {
        return tshirtDao.getAllTshirts();
    }

    public List<Tshirt> getTshirtByColor(String color) {
        return tshirtDao.getTshirtByColor(color);
    }

    public List<Tshirt> getTshirtBySize(String size) {
        return tshirtDao.getTshirtBySize(size);
    }

    public void updateTshirt(Tshirt tshirt) {
        tshirtDao.updateTshirt(tshirt);
    }

    public void deleteTshirt(int id) {
        tshirtDao.deleteTshirt(id);
    }



    //save
    @Transactional
    public Invoice addInvoice(Invoice invoice)
    {
        //Persist Invoice
        Invoice i = new Invoice();
        i.setName(invoice.getName());
        i.setStreet(invoice.getStreet());
        i.setCity(invoice.getCity());
        i.setState(invoice.getState());
        i.setZipcode(invoice.getZipcode());
        i.setItemType(invoice.getItemType());
        i.setItemId(invoice.getItemId());
        i.setQuantity(invoice.getQuantity());

        if(i.getItemType().equals("console"))
        {

            //find specific console and input correct values
            List<Console> consoleList = consoleDao.getAllConsoles();
            for (Console console : consoleList)
            {
                if(console.getId() == i.getItemId())
                {
                    //set unitPrice
                    i.setUnitPrice(console.getPrice());

                    //set subtotal
                    i.setSubtotal(console.getPrice().multiply(new BigDecimal(i.getQuantity())));

                    //set processing fee
                    ProcessingFee processingFee = processingFeeDao.getProcessingFeeByType("Consoles");
                    i.setProcessingFee(processingFee.getFee());
                    if(i.getQuantity() >= 10)
                    {
                        i.setProcessingFee(i.getProcessingFee().add(new BigDecimal(15.49)));
                    }

                    //set taxes
                    Tax tax = taxDao.getTaxByState(invoice.getState());
                    i.setTax(tax.getRate().multiply(i.getSubtotal()));

                    //set the total
                    i.setTotal(i.getProcessingFee().add(i.getTax().add(i.getSubtotal())));
                }
            }
        }

        else if(i.getItemType().equals("game"))
        {
            List<Game> gameList = gameDao.getAllGames();
            for (Game game : gameList)
            {
                if(game.getId() == i.getItemId())
                {
                    //set unitPrice
                    i.setUnitPrice(game.getPrice());

                    //set subtotal
                    i.setSubtotal(game.getPrice().multiply(new BigDecimal(i.getQuantity())));

                    //set processing fee
                    ProcessingFee processingFee = processingFeeDao.getProcessingFeeByType("Games");
                    i.setProcessingFee(processingFee.getFee());
                    if(i.getQuantity() >= 10)
                    {
                        i.setProcessingFee(i.getProcessingFee().add(new BigDecimal(15.49)));
                    }

                    //set taxes
                    Tax tax = taxDao.getTaxByState(invoice.getState());
                    i.setTax(tax.getRate().multiply(i.getSubtotal()));

                    //set the total
                    i.setTotal(i.getProcessingFee().add(i.getTax().add(i.getSubtotal())));
                }
            }
        }

        else if(i.getItemType().equals("tshirt"))
        {
            List<Tshirt> tshirtList = tshirtDao.getAllTshirts();
            for (Tshirt tshirt : tshirtList)
            {
                if(tshirt.getId() == i.getItemId())
                {
                    //set unitPrice
                    i.setUnitPrice(tshirt.getPrice());

                    //set subtotal
                    i.setSubtotal(tshirt.getPrice().multiply(new BigDecimal(i.getQuantity())));

                    //set processing fee
                    ProcessingFee processingFee = processingFeeDao.getProcessingFeeByType("T-shirts");
                    i.setProcessingFee(processingFee.getFee());
                    if(i.getQuantity() >= 10)
                    {
                        i.setProcessingFee(i.getProcessingFee().add(new BigDecimal(15.49)));
                    }

                    //set taxes
                    Tax tax = taxDao.getTaxByState(invoice.getState());
                    i.setTax(tax.getRate().multiply(i.getSubtotal()));

                    //set the total
                    i.setTotal(i.getProcessingFee().add(i.getTax().add(i.getSubtotal())));
                }
            }
        }

        i = invoiceDao.addInvoice(i);
        invoice.setId(i.getId());

        return i;
    }
}
