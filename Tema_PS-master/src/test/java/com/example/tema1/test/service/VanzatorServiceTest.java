package com.example.tema1.test.service;

import com.example.tema1.model.Film;
import com.example.tema1.model.Vanzator;
import com.example.tema1.repo.FilmRepository;
import com.example.tema1.repo.VanzatorRepository;
import com.example.tema1.service.FilmService;
import com.example.tema1.service.VanzatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

/**
 * The type Vanzator service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VanzatorServiceTest {

    @Mock
    private VanzatorRepository vanzatorRepository;
    private VanzatorService vanzatorService;

    /**
     * Create instance.
     */
    @BeforeEach
    void createInstance(){
        vanzatorService = new VanzatorService(vanzatorRepository);
    }

    /**
     * Test find all.
     */
    @Test
    void testFindAll(){
        vanzatorService.findAll();
        verify(vanzatorRepository).findAll();
    }

    /**
     * Test insert.
     */
    @Test
    void testInsert(){
        Vanzator vanzator = new Vanzator("George2", "8-12", 1, "george2022", "2022george");
        vanzatorService.save(vanzator);
        verify(vanzatorRepository).save(vanzator);
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
