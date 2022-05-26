package com.example.tema1.service;

import com.example.tema1.model.Client;
import com.example.tema1.model.Film;

import java.util.Optional;

/**
 * The interface Film service.
 */
public interface IFilmService {
    /**
     * Save film.
     *
     * @param film the film
     * @return the film
     */
    Film save(Film film);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Film> findById(Long id);

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
    Iterable<Film> findAll();

    /**
     * Count long.
     *
     * @return the long
     */
    Long count();
}
