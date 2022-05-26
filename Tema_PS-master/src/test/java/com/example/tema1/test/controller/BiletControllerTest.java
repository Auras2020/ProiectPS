package com.example.tema1.test.controller;

import com.example.tema1.controller.BiletController;
import com.example.tema1.model.Bilet;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

/**
 * The type Bilet controller test.
 */
@SpringBootTest
public class BiletControllerTest {

    @Autowired
    private BiletController biletController;

    /**
     * Test creare bilet film.
     */
    @Test
    public void testCreareBiletFilm(){
        Bilet bilet = biletController.createBiletFilm((long)1, (long)1);
        Bilet bilet1 = new Bilet(1, "Andrei", "Aftermath");
        Assertions.assertEquals(bilet, bilet1);
    }

    /**
     * Test creare bilet spectacol.
     */
    @Test
    public void testCreareBiletSpectacol(){
        Bilet bilet = biletController.createBiletSpectacol((long)1, (long)1);
        Bilet bilet1 = new Bilet(1, "Andrei", "Aievea");
        Assertions.assertEquals(bilet, bilet1);
    }
}
