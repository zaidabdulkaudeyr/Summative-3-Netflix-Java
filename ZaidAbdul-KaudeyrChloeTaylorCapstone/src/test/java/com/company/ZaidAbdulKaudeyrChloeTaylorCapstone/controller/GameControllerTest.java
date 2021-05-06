package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.GameDao;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Game;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
@AutoConfigureMockMvc(addFilters = false)
public class GameControllerTest {

    // wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vise versa
    private ObjectMapper mapper = new ObjectMapper();

    //list for testing
    @MockBean
    GameDao gameDao;



    @Test
    public void shouldReturnAllGames() throws Exception{
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(gameDao.getAllGames());
        // ACT
        mockMvc.perform(get("/game"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    public void getGamesByStudio() throws Exception{
        Game outputGame = new Game();
        outputGame.setTitle("Super Smash Bros. Ultimate");
        outputGame.setEsrbRating("E10+");
        outputGame.setDescription("A multiplayer action fighting game");
        outputGame.setPrice(new BigDecimal("59.60"));
        outputGame.setStudio("Bandai");
        outputGame.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("/gameStudio/Bandai"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getGamesByESRB() throws Exception{
        Game outputGame = new Game();
        outputGame.setTitle("Super Smash Bros. Ultimate");
        outputGame.setEsrbRating("E10+");
        outputGame.setDescription("A multiplayer action fighting game");
        outputGame.setPrice(new BigDecimal("59.60"));
        outputGame.setStudio("Bandai");
        outputGame.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("/gameStudio/E10+"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getGamesByTitle() throws Exception{
        Game outputGame = new Game();
        outputGame.setTitle("Super Smash Bros. Ultimate");
        outputGame.setEsrbRating("E10+");
        outputGame.setDescription("A multiplayer action fighting game");
        outputGame.setPrice(new BigDecimal("59.60"));
        outputGame.setStudio("Bandai");
        outputGame.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("/gameStudio/Super Smash Bros. Ultimate"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnGameById() throws Exception{
        Game outputGame = new Game();
        outputGame.setTitle("Super Smash Bros. Ultimate");
        outputGame.setEsrbRating("E10+");
        outputGame.setDescription("A multiplayer action fighting game");
        outputGame.setPrice(new BigDecimal("59.60"));
        outputGame.setStudio("Bandai");
        outputGame.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("/gameStudio/4"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addGame() throws Exception{
// Arrange
        Game game = new Game();
        game.setTitle("Super Smash Bros. Ultimate");
        game.setEsrbRating("E10+");
        game.setDescription("A multiplayer action fighting game");
        game.setPrice(new BigDecimal("59.60"));
        game.setStudio("Bandai Namco Studios");
        game.setQuantity(5);

        // Convert Java to JSON
        String inputJson = mapper.writeValueAsString(game);

        Game outputGame = new Game();
        outputGame.setTitle("Super Smash Bros. Ultimate");
        outputGame.setEsrbRating("E10+");
        outputGame.setDescription("A multiplayer action fighting game");
        outputGame.setPrice(new BigDecimal("59.60"));
        outputGame.setStudio("Bandai Namco Studios");
        outputGame.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputGame);

        // ACT
        mockMvc.perform(
                post("/game")                            // Perform the POST request
                        .content(inputJson)                       // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
        )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    //update testing
    @Test
    public void updateGame() throws Exception {

        Game inputGame = new Game();
        inputGame.setTitle("Super Smash Bros. Ultimate");
        inputGame.setEsrbRating("E10+");
        inputGame.setDescription("A multiplayer action fighting game");
        inputGame.setPrice(new BigDecimal("45.89"));
        inputGame.setStudio("Bandai Namco Studios");
        inputGame.setQuantity(5);

        //convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputGame);

        mockMvc.perform(
                put("/game")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    //delete testing
    @Test
    public void shouldDeleteByIdGame() throws Exception {
        mockMvc.perform(delete("/game/4"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}