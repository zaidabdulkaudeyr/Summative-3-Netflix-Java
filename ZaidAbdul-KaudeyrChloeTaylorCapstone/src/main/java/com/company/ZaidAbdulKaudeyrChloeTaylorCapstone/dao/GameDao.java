package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByESRB(String esrbRating);

    List<Game> getGamesByTitle(String title);

    void updateGame(Game game);

    void deleteGame(int id);
}
