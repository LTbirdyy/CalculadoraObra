package com.example.calculadora_obra;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
class ComodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCriarComodo() throws Exception {

        String json = """
        {
          "nome": "Sala",
          "largura": 4.0,
          "comprimento": 5.0,
          "altura": 2.8,
          "paredes": []
        }
        """;

        mockMvc.perform(post("/comodos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Sala"));
    }
}