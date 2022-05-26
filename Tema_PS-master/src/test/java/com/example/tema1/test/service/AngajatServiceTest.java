package com.example.tema1.test.service;

import com.example.tema1.controller.AngajatController;
import com.example.tema1.model.Angajat;
import com.example.tema1.repo.AngajatRepository;
import com.example.tema1.service.AngajatService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.verify;

/**
 * The type Angajat service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AngajatServiceTest {

    @Mock
    private AngajatRepository angajatRepository;
    private AngajatService angajatService;

    /**
     * Create instance.
     */
    @BeforeEach
    void createInstance(){
        angajatService = new AngajatService(angajatRepository);
    }

    /**
     * Test find all.
     */
    @Test
    void testFindAll(){
        angajatService.findAll();
        verify(angajatRepository).findAll();
    }

    /**
     * Test insert.
     */
    @Test
    void testInsert(){
        Angajat angajat = new Angajat("Doru", "12-20", 20, "dor2022", "2022dor");
        angajatService.save(angajat);
        verify(angajatRepository).save(angajat);
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
