package com.example.tema1.service;

import com.example.tema1.model.Film;
import com.example.tema1.model.Spectacol;

import java.util.Optional;

/**
 * The interface Spectacol service.
 */
public interface ISpectacolService {
    /**
     * Save spectacol.
     *
     * @param spectacol the spectacol
     * @return the spectacol
     */
    Spectacol save(Spectacol spectacol);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Spectacol> findById(Long id);

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
    Iterable<Spectacol> findAll();

    /**
     * Count long.
     *
     * @return the long
     */
    Long count();
}
