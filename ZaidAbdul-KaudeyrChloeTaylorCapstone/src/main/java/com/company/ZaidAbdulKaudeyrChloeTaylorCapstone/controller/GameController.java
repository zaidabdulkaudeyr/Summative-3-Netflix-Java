package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.GameDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameDao gameDao;

    @GetMapping(value = "/game")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        List<Game> games = gameDao.getAllGames();
        return games;
    }

    @RequestMapping(value = "/gameStudio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    @RequestMapping(value = "/gameESRB/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByESRB(@PathVariable String esrbRating) {
        return gameDao.getGamesByESRB(esrbRating);
    }

    @RequestMapping(value = "/gameTitle/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {
        return gameDao.getGamesByTitle(title);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGame(@PathVariable int id) {
        return gameDao.getGame(id);
    }

    @PostMapping(value = "/game")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game) {
        return gameDao.addGame(game);
    }

    @PutMapping(value = "/game")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game) {
        System.out.println("Updating Game id = " + game.getId());
        gameDao.updateGame(game);
    }

    @DeleteMapping(value = "/game/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        System.out.println("Game deleted");
        gameDao.deleteGame(id);
    }

}
