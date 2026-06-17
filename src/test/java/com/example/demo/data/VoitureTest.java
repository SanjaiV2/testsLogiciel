package com.example.demo.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {

    @Test
    void creerVoiture(){

        Voiture v = new Voiture();

        v.setId(1);
        v.setMarque("Audi");
        v.setPrix(30000);

        assertEquals(1, v.getId());
        assertEquals("Audi", v.getMarque());
        assertEquals(30000, v.getPrix());

        assertNotNull(v.toString());
    }

}