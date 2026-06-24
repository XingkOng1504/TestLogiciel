package com.example.demo.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture v = new Voiture("Ferrari", 2000);
        v.setPrix(3000);
        assertEquals(3000, v.getPrix());
    }

    @Test
    void testerMarque(){
        Voiture v = new Voiture("Ferrari", 2000);
        assertEquals("Ferrari", v.getMarque());
    }

    @Test
    void modifierMarque(){
        Voiture v = new Voiture("Ferrari", 2000);
        v.setMarque("Porsche");
        assertEquals("Porsche", v.getMarque());
    }

    @Test
    void testerId(){
        Voiture v = new Voiture();
        v.setId(42);
        assertEquals(42, v.getId());
    }


}
