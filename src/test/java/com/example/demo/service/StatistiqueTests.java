package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.data.Voiture;

@SpringBootTest
public class StatistiqueTests {

    @Test
    void testStatistique() {
        StatistiqueImpl statistique = new StatistiqueImpl();
        Voiture v1 = new Voiture("Ferrari", 3000);
        Voiture v2 = new Voiture("Porsche", 3000);
        statistique.ajouter(v1);
        statistique.ajouter(v2);
        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(3000, echantillon.getPrixMoyen());
        assertEquals(2, echantillon.getNombreDeVoitures());
    }

    @Test
    void testPrixDifferents(){
        StatistiqueImpl statistique = new StatistiqueImpl();
        statistique.ajouter(new Voiture("Ferrari", 1000));
        statistique.ajouter(new Voiture("Porsche", 3000));
        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(2000, echantillon.getPrixMoyen());
        assertEquals(2, echantillon.getNombreDeVoitures());
    }

    @Test
    void testListeVide(){
        StatistiqueImpl statistique = new StatistiqueImpl();
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }


}
