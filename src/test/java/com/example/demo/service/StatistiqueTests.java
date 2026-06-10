package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    void ajouterDeuxVoitures() throws ArithmeticException {
        Voiture v1 = new Voiture("BMW", 20000);
        Voiture v2 = new Voiture("Audi", 30000);

        statistiqueImpl.ajouter(v1);
        statistiqueImpl.ajouter(v2);

        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(2, 25000));

        Echantillon e = statistiqueImpl.prixMoyen();

        assertEquals(2, e.getNombreDeVoitures());
        assertEquals(25000, e.getPrixMoyen());
    }

}
