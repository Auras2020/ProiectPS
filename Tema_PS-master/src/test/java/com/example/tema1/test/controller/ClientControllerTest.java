package com.example.tema1.test.controller;

import com.example.tema1.controller.AngajatController;
import com.example.tema1.controller.ClientController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The type Client controller test.
 */
@SpringBootTest
public class ClientControllerTest {

    @Autowired
    private ClientController clientController;

    /**
     * Test login.
     */
    @Test
    void testLogin(){
        Assertions.assertEquals(clientController.loginClient((long)2), "Login credentials are ok!");
    }
}
