package com.example.tema1.test.repository;

import com.example.tema1.model.Film;
import com.example.tema1.model.Spectacol;
import com.example.tema1.repo.FilmRepository;
import com.example.tema1.repo.SpectacolRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * The type Spectacol repository test.
 */
@SpringBootTest
public class SpectacolRepositoryTest {

    @Autowired
    private SpectacolRepository spectacolRepository;

    /**
     * Test spectacol repository.
     */
    @Test
    void testSpectacolRepository(){
        Spectacol spectacol = new Spectacol("Aievea1", "populara", "09-12-2021", "Bucuresti", "Andra", "20-22");
        spectacolRepository.save(spectacol);
        Optional<Spectacol> s1 = spectacolRepository.findById((long)6);
        assertThat(s1).isPresent();
        spectacolRepository.delete(spectacol);
    }

    /**
     * Test delete by id.
     */
    @Test
    void testDeleteById(){
        if(spectacolRepository.existsById((long)2)){
            Optional<Spectacol> s = spectacolRepository.findById((long)2);
            int s1 = (int) spectacolRepository.count();
           spectacolRepository.deleteById((long)2);
            int s2 = (int) spectacolRepository.count();
            spectacolRepository.save(s.get());

            Assertions.assertEquals(s1, s2 + 1);
        }
    }
}
