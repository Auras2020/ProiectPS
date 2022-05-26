package com.example.tema1.test.service;

import com.example.tema1.model.Film;
import com.example.tema1.model.Spectacol;
import com.example.tema1.repo.FilmRepository;
import com.example.tema1.repo.SpectacolRepository;
import com.example.tema1.service.FilmService;
import com.example.tema1.service.SpectacolService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

/**
 * The type Spectacol service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SpectacolServiceTest {

    @Mock
    private SpectacolRepository spectacolRepository;
    private SpectacolService spectacolService;

    /**
     * Create instance.
     */
    @BeforeEach
    void createInstance(){
        spectacolService = new SpectacolService(spectacolRepository);
    }

    /**
     * Test find all.
     */
    @Test
    void testFindAll(){
        spectacolService.findAll();
        verify(spectacolRepository).findAll();
    }

    /**
     * Test insert.
     */
    @Test
    void testInsert(){
        Spectacol spectacol = new Spectacol("Aievea2", "populara", "09-12-2021", "Bucuresti", "Andra", "20-22");
        spectacolService.save(spectacol);
        verify(spectacolRepository).save(spectacol);
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
