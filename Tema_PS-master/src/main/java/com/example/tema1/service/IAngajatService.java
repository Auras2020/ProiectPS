package com.example.tema1.service;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Client;

import java.util.Optional;

/**
 * The interface Angajat service.
 */
public interface IAngajatService {

    /**
     * Save angajat.
     *
     * @param angajat the angajat
     * @return the angajat
     */
    Angajat save(Angajat angajat);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Angajat> findById(Long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

    /**
     * Find all iterable.
     *
     * @return the iterable
     */
    Iterable<Angajat> findAll();

    /**
     * Count long.
     *
     * @return the long
     */
    Long count();
}
