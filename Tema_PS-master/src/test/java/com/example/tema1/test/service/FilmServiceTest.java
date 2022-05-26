package com.example.tema1.test.service;

import com.example.tema1.model.Client;
import com.example.tema1.model.Film;
import com.example.tema1.repo.ClientRepository;
import com.example.tema1.repo.FilmRepository;
import com.example.tema1.service.ClientService;
import com.example.tema1.service.FilmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

/**
 * The type Film service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {

    @Mock
    private FilmRepository filmRepository;
    private FilmService filmService;

    /**
     * Create instance.
     */
    @BeforeEach
    void createInstance(){
        filmService = new FilmService(filmRepository);
    }

    /**
     * Test find all.
     */
    @Test
    void testFindAll(){
        filmService.findAll();
        verify(filmRepository).findAll();
    }

    /**
     * Test insert.
     */
    @Test
    void testInsert(){
        Film film = new Film("Aftermath2", "horror", 15, "simplu", "12:15 06-04-2020 Mi", 34, 18, "Peter Winther",
                "Ashley Greene, Shawn Ashmo, Jason Liles");
        filmService.save(film);
        verify(filmRepository).save(film);
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
