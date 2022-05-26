package com.example.tema1.test.service;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Client;
import com.example.tema1.repo.AngajatRepository;
import com.example.tema1.repo.ClientRepository;
import com.example.tema1.service.AngajatService;
import com.example.tema1.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

/**
 * The type Client service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;
    private ClientService clientService;

    /**
     * Create instance.
     */
    @BeforeEach
    void createInstance(){
        clientService = new ClientService(clientRepository);
    }

    /**
     * Test find all.
     */
    @Test
    void testFindAll(){
        clientService.findAll();
        verify(clientRepository).findAll();
    }

    /**
     * Test insert.
     */
    @Test
    void testInsert(){
        Client client = new Client("Matei1", 21, "DA", "mat2022", "2022mat");
        clientService.save(client);
        verify(clientRepository).save(client);
    }

    /**
     * Test delete.
     */
    @Test
    @Disabled
    void testDelete(){
    }

    /**
     * Test update.
     */
    @Test
    @Disabled
    void testUpdate(){
    }
}
