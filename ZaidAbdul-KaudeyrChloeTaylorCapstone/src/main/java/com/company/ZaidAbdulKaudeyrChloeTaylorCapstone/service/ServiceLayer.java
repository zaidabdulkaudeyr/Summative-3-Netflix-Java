package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.*;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Invoice;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public InvoiceViewModel saveAlbum(InvoiceViewModel viewModel)
    {
        // Persist Album
        Invoice i = new Invoice();
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setZipcode(viewModel.getZipcode());
        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setUnitPrice(viewModel.getUnitPrice());
        i.setQuantity(viewModel.getQuantity());

        i = invoiceDao.addInvoice(i);
        viewModel.setId(i.getId());

        if(i.getItemType() == "console")
        {

        }
        else if(i.getItemType() == "game")
        {

        }
        else if(i.getItemType() == "tshirt")
        {

        }

        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());
        a = albumDao.addAlbum(a);
        viewModel.setId(a.getId());
        // Add Album Id to Tracks and Persist Tracks
        List<Track> tracks = viewModel.getTracks();
        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    trackDao.addTrack(t);
                });
        tracks = trackDao.getTracksByAlbum(viewModel.getId());
        viewModel.setTracks(tracks);
        return viewModel;
    }
}
