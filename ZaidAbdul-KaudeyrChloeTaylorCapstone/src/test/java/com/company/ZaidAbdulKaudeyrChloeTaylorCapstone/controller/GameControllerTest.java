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
        outputGame.setStudio("Bandai Namco Studios");
        outputGame.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputGame);

        mockMvc.perform(get("gameStudio/Bandai Namco Studios"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getGamesByESRB() throws Exception{
    }

    @Test
    public void getGamesByTitle() throws Exception{
    }

    @Test
    public void shouldReturnGameById() throws Exception{

    }

    @Test
    public void addGame() throws Exception{
    }
}