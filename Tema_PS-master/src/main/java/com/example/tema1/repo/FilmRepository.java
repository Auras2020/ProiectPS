package com.example.tema1.repo;

import com.example.tema1.model.Film;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Film repository.
 */
public interface FilmRepository extends CrudRepository<Film, Long> {
}
