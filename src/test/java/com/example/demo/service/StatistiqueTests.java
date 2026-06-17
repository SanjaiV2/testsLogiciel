package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StatistiqueTests {

    @Test
    void testMockito() {

        Statistique statistique = mock(Statistique.class);

        when(statistique.prixMoyen())
                .thenReturn(new Echantillon(2,25000));

        Echantillon e = statistique.prixMoyen();

        assertEquals(2, e.getNombreDeVoitures());
        assertEquals(25000, e.getPrixMoyen());

        verify(statistique).prixMoyen();
    }

    @Test
    void testPrixMoyen() {

        StatistiqueImpl s = new StatistiqueImpl();

        s.ajouter(new Voiture("BMW",20000));
        s.ajouter(new Voiture("Audi",30000));

        Echantillon e = s.prixMoyen();

        assertEquals(2, e.getNombreDeVoitures());
        assertEquals(25000, e.getPrixMoyen());
    }

    @Test
    void testPrixMoyenException() {

        StatistiqueImpl s = new StatistiqueImpl();

        assertThrows(ArithmeticException.class,
                () -> s.prixMoyen());
    }

    @Test
    void testEchantillonVide() {

        Echantillon e = new Echantillon();

        e.setNombreDeVoitures(3);
        e.setPrixMoyen(15000);

        assertEquals(3, e.getNombreDeVoitures());
        assertEquals(15000, e.getPrixMoyen());
    }
}
