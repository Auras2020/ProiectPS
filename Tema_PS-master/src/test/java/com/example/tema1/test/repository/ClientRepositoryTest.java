package com.example.tema1.test.repository;

import com.example.tema1.model.Client;
import com.example.tema1.repo.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * The type Client repository test.
 */
@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Test client repository.
     */
    @Test
    void testClientRepository(){
        Client client = new Client("Matei", 21, "DA", "mat2022", "2022mat");
        clientRepository.save(client);
        Optional<Client> c1 = clientRepository.findById((long)11);
        assertThat(c1).isPresent();
        clientRepository.delete(client);
    }

    /**
     * Test delete by id.
     */
    @Test
    void testDeleteById(){
        if(clientRepository.existsById((long)4)){
            Optional<Client> c1 = clientRepository.findById((long)4);
            int s1 = (int) clientRepository.count();
            clientRepository.deleteById((long)4);
            int s2 = (int) clientRepository.count();
            clientRepository.save(c1.get());

            Assertions.assertEquals(s1, s2 + 1);
        }
    }
}
