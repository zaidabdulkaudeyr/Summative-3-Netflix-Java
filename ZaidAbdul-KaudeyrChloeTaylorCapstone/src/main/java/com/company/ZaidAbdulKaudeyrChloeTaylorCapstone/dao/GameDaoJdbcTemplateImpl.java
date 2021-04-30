package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl
{
    private JdbcTemplate jdbcTemplate;

    //Prepared statements strings

    private static final String INSERT_CONSOLE_SQL =
            "insert into console (model, manufacturer, memory_amount) values ()";

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    @Transactional
    Game addGame(Game game)
    {
        return null;
    }

    @Override
    Game getGame(int id)
    {
        return null;
    }

    @Override
    List<Game> getAllGames()
    {
        return null;
    }

    @Override
    List<Game> getGamesByStudio(String studio)
    {
        return null;
    }

    @Override
    List<Game> getGamesByESRB(String esrbRating)
    {
        return null;
    }

    @Override
    List<Game> getGamesByTitle(String title)
    {
        return null;
    }

    @Override
    void updateGame(Game game)
    {

    }

    @Override
    void deleteGame(int id)
    {

    }
}
