package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GameController.class)
@ContextConfiguration(classes = {GameController.class, GameService.class})
public class GameControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    GameService gameService;

    @Test
    public void testSetBound() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/setBound")
                        .param("lowerBound", "1")
                        .param("upperBound", "10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        String expected = "Your Input Is Valid. Please Try To Guess It!";

        assertEquals(expected, response);
    }

}