package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.*;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    Console getConsole(int id) {
        return consoleDao.getConsole(id);
    }

    List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    List<Console> getConsolesByManufacturer(String manufacturer) {
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }

    void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    void deleteConsole(int id) {
        consoleDao.deleteConsole(id);
    }


    //
    // game API
    //
    Game addGame(Game game) {
        return gameDao.addGame(game);
    }

    Game getGame(int id) {
        return gameDao.getGame(id);
    }

    List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    List<Game> getGamesByStudio(String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    List<Game> getGamesByESRB(String esrbRating) {
        return gameDao.getGamesByESRB(esrbRating);
    }

    List<Game> getGamesByTitle(String title) {
        return gameDao.getGamesByTitle(title);
    }

    void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    void deleteGame(int id) {
        gameDao.deleteGame(id);
    }


    //
    //Tshirt API
    //
    Tshirt addTshirt(Tshirt tshirt) {
        return tshirtDao.addTshirt(tshirt);
    }

    Tshirt getTshirt(int id) {
        return tshirtDao.getTshirt(id);
    }

    List<Tshirt> getAllTshirts() {
        return tshirtDao.getAllTshirts();
    }

    List<Tshirt> getTshirtByColor(String color) {
        return tshirtDao.getTshirtByColor(color);
    }

    List<Tshirt> getTshirtBySize(String size) {
        return tshirtDao.getTshirtBySize(size);
    }

    void updateTshirt(Tshirt tshirt) {
        tshirtDao.updateTshirt(tshirt);
    }

    void deleteTshirt(int id) {
        tshirtDao.deleteTshirt(id);
    }


}
