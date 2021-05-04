package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;


import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
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
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception{
        // Clean up the test database
        List<Game> dList = gameDao.getAllGames();
        for (Game d : dList){
            gameDao.deleteGame(d.getId());
        }
    }

    @Test
    public void addGetDeleteConsole() {
        //Arrange
        Game game = new Game();
        game.setTitle("Super Smash Bros. Ultimate");
        game.setEsrbRating("E10+");
        game.setDescription("A multiplayer action fighting game");
        game.setPrice(new BigDecimal("59.60"));
        game.setStudio("Bandai Namco Studios");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getId());

        //Assert
        assertEquals(game1, game);

        gameDao.deleteGame(game.getId());
        game1 = gameDao.getGame(game.getId());

        //Assert
        assertNull(game1);
    }

    @Test
    public void getAllGames() {

        //First Game
        Game game = new Game();
        game.setTitle("Super Smash Bros. Ultimate");
        game.setEsrbRating("E10+");
        game.setDescription("A multiplayer action fighting game");
        game.setPrice(new BigDecimal("59.60"));
        game.setStudio("Bandai Namco Studios");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        //Second Game
        Game game1 = new Game();
        game1.setTitle("Final Fantasy VII Remake");
        game1.setEsrbRating("T");
        game1.setDescription("A JRPG");
        game1.setPrice(new BigDecimal("59.99"));
        game1.setStudio("Square Enix");
        game1.setQuantity(3);

        game1 = gameDao.addGame(game1);

        List<Game> bList = gameDao.getAllGames();

        assertEquals(bList.size(), 2);
    }

    @Test
    public void getGamesByStudio() {

        //First Game
        Game game = new Game();
        game.setTitle("Super Smash Bros. Ultimate");
        game.setEsrbRating("E10+");
        game.setDescription("A multiplayer action fighting game");
        game.setPrice(new BigDecimal("59.60"));
        game.setStudio("Bandai Namco Studios");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        //Second Game
        Game game1 = new Game();
        game1.setTitle("Final Fantasy VII Remake");
        game1.setEsrbRating("T");
        game1.setDescription("A JRPG");
        game1.setPrice(new BigDecimal("59.99"));
        game1.setStudio("Square Enix");
        game1.setQuantity(3);

        game1 = gameDao.addGame(game1);

        List<Game> bList = gameDao.getGamesByStudio("Bandai Namco Studios");

        //Assert
        assertEquals(bList.size(), 1);
    }

    @Test
    public void getGamesByESRB() {
        //First Game
        Game game = new Game();
        game.setTitle("Super Smash Bros. Ultimate");
        game.setEsrbRating("E10+");
        game.setDescription("A multiplayer action fighting game");
        game.setPrice(new BigDecimal("59.60"));
        game.setStudio("Bandai Namco Studios");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        //Second Game
        Game game1 = new Game();
        game1.setTitle("Final Fantasy VII Remake");
        game1.setEsrbRating("T");
        game1.setDescription("A JRPG");
        game1.setPrice(new BigDecimal("59.99"));
        game1.setStudio("Square Enix");
        game1.setQuantity(3);

        game1 = gameDao.addGame(game1);

        List<Game> bList = gameDao.getGamesByESRB("T");

        //Assert
        assertEquals(bList.size(), 1);
    }

    @Test
    public void getGamesByTitle() {
        //First Game
        Game game = new Game();
        game.setTitle("Super Smash Bros. Ultimate");
        game.setEsrbRating("E10+");
        game.setDescription("A multiplayer action fighting game");
        game.setPrice(new BigDecimal("59.60"));
        game.setStudio("Bandai Namco Studios");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        //Second Game
        Game game1 = new Game();
        game1.setTitle("Final Fantasy VII Remake");
        game1.setEsrbRating("T");
        game1.setDescription("A JRPG");
        game1.setPrice(new BigDecimal("59.99"));
        game1.setStudio("Square Enix");
        game1.setQuantity(3);

        game1 = gameDao.addGame(game1);

        List<Game> bList = gameDao.getGamesByTitle("Super Smash Bros. Ultimate");

        //Assert
        assertEquals(bList.size(), 1);
    }

    @Test
    public void updateGame() {

        //add game
        Game game = new Game();
        game.setTitle("Super Smash Bros. Ultimate");
        game.setEsrbRating("E10+");
        game.setDescription("A multiplayer action fighting game");
        game.setPrice(new BigDecimal("59.60"));
        game.setStudio("Bandai Namco Studios");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        game.setTitle("Super Smash Bros. Melee");
        game.setPrice(new BigDecimal("19.99"));
        game.setQuantity(2);

        //updates game
        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getId());
        assertEquals(game1, game);
    }
}