package com.example.demo.web;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetVoitures() throws Exception {

       /* 
        StatistiqueImpl statistiqueImpl = new StatistiqueImpl();
        statistiqueImpl.ajouter(new Voiture("Toyota", 2020));
        Echantillon e =   statistiqueImpl.prixMoyen();
        */
        
        
        Echantillon echantillon = new Echantillon();
        echantillon.setNombreDeVoitures(2);
        echantillon.setPrixMoyen(2000);

        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        mockMvc.perform(get("/statistique")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(2000));

    }

    @Test
    void testAjouterVoiture() throws Exception {
        mockMvc.perform(post("/voiture")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"marque\":\"Ferrari\",\"prix\":3000}"))
                .andExpect(status().isOk());
    }


  

}
