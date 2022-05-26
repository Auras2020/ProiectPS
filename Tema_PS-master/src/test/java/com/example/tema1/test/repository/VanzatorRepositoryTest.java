package com.example.tema1.test.repository;

import com.example.tema1.model.Film;
import com.example.tema1.model.Vanzator;
import com.example.tema1.repo.FilmRepository;
import com.example.tema1.repo.VanzatorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * The type Vanzator repository test.
 */
@SpringBootTest
public class VanzatorRepositoryTest {

    @Autowired
    private VanzatorRepository vanzatorRepository;

    /**
     * Test vanzator repository.
     */
    @Test
    void testVanzatorRepository(){
        Vanzator vanzator = new Vanzator("George1", "8-12", 1, "george2022", "2022george");
        vanzatorRepository.save(vanzator);
        Optional<Vanzator> v1 = vanzatorRepository.findById((long)10);
        assertThat(v1).isPresent();
        vanzatorRepository.delete(vanzator);
    }

    /**
     * Test delete by id.
     */
    @Test
    void testDeleteById(){
        if(vanzatorRepository.existsById((long)2)){
            Optional<Vanzator> v1 = vanzatorRepository.findById((long)2);
            int s1 = (int) vanzatorRepository.count();
            vanzatorRepository.deleteById((long)2);
            int s2 = (int) vanzatorRepository.count();
            vanzatorRepository.save(v1.get());

            Assertions.assertEquals(s1, s2 + 1);
        }
    }
}
