package com.example.tema1.test.repository;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Client;
import com.example.tema1.repo.AngajatRepository;
import com.example.tema1.repo.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * The type Angajat repository test.
 */
@SpringBootTest
public class AngajatRepositoryTest {

    @Autowired
    private AngajatRepository angajatRepository;

    /**
     * Test angajat repository.
     */
    @Test
    void testAngajatRepository(){
        Angajat angajat = new Angajat("Doru", "12-20", 20, "dor2022", "2022dor");
        angajatRepository.save(angajat);
        Optional<Angajat> a1 = angajatRepository.findById((long)4);
        assertThat(a1).isPresent();
        angajatRepository.delete(angajat);
    }

    /**
     * Test delete by id.
     */
    @Test
    void testDeleteById(){
        if(angajatRepository.existsById((long)2)){
            Optional<Angajat> a1 = angajatRepository.findById((long)2);
            int s1 = (int) angajatRepository.count();
            angajatRepository.deleteById((long)2);
            int s2 = (int) angajatRepository.count();
            angajatRepository.save(a1.get());

            Assertions.assertEquals(s1, s2 + 1);
        }
    }
}
