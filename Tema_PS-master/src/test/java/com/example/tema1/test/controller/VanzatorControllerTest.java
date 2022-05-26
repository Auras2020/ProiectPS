package com.example.tema1.test.controller;

import com.example.tema1.controller.AngajatController;
import com.example.tema1.controller.ClientController;
import com.example.tema1.controller.VanzatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The type Vanzator controller test.
 */
@SpringBootTest
public class VanzatorControllerTest {

    @Autowired
    private VanzatorController vanzatorController;

    /**
     * Test login.
     */
    @Test
    void testLogin(){
        Assertions.assertEquals(vanzatorController.loginVanzator((long)2), "Login credentials are ok!");
    }
}
