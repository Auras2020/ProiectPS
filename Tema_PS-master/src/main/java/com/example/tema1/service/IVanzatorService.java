package com.example.tema1.service;

import com.example.tema1.model.Client;
import com.example.tema1.model.Vanzator;

import java.util.Optional;

/**
 * The interface Vanzator service.
 */
public interface IVanzatorService {

    /**
     * Save vanzator.
     *
     * @param vanzator the vanzator
     * @return the vanzator
     */
    Vanzator save(Vanzator vanzator);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Vanzator> findById(Long id);

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
    Iterable<Vanzator> findAll();

    /**
     * Count long.
     *
     * @return the long
     */
    Long count();
}
