package com.example.tema1.test.controller;

import com.example.tema1.controller.AngajatController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The type Angajat controller test.
 */
@SpringBootTest
public class AngajatControllerTest {

    @Autowired
    private AngajatController angajatController;

    /**
     * Test login.
     */
    @Test
    void testLogin(){
        Assertions.assertEquals(angajatController.loginAngajat((long)2), "Login credentials are ok!");
    }
}
