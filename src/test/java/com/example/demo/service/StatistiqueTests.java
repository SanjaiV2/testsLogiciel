package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

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


}