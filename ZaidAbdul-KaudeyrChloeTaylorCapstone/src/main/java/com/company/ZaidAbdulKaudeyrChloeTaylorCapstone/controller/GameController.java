package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    ServiceLayer service;

    @GetMapping(value = "/game")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        List<Game> games = service.getAllGames();
        return games;
    }

    @RequestMapping(value = "/gameStudio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio) {
        return service.getGamesByStudio(studio);
    }

    @RequestMapping(value = "/gameESRB/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByESRB(@PathVariable String esrbRating) {
        return service.getGamesByESRB(esrbRating);
    }

    @RequestMapping(value = "/gameTitle/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title) {
        return service.getGamesByTitle(title);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGame(@PathVariable int id) {
        return service.getGame(id);
    }

    @PostMapping(value = "/game")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game) {
        return service.addGame(game);
    }

    @PutMapping(value = "/game/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable int id, @RequestBody Game game) {
        game.setId(id);
        service.updateGame(game);
    }

    @DeleteMapping(value = "/game/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        service.deleteGame(id);
    }

}
