package com.example.tema1.test.repository;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Film;
import com.example.tema1.repo.AngajatRepository;
import com.example.tema1.repo.FilmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * The type Film repository test.
 */
@SpringBootTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    /**
     * Test film repository.
     */
    @Test
    void testFilmRepository(){
        Film film = new Film("Aftermath1", "horror", 15, "simplu", "12:15 06-04-2020 Mi", 34, 18, "Peter Winther",
                "Ashley Greene, Shawn Ashmo, Jason Liles");
        filmRepository.save(film);
        Optional<Film> f1 = filmRepository.findById((long)11);
        assertThat(f1).isPresent();
        filmRepository.delete(film);
    }

    /**
     * Test delete by id.
     */
    @Test
    void testDeleteById(){
        if(filmRepository.existsById((long)2)){
            Optional<Film> f1 = filmRepository.findById((long)2);
            int s1 = (int) filmRepository.count();
            filmRepository.deleteById((long)2);
            int s2 = (int) filmRepository.count();
            filmRepository.save(f1.get());

            Assertions.assertEquals(s1, s2 + 1);
        }
    }
}
