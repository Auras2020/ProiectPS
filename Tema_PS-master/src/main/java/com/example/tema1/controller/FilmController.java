package com.example.tema1.controller;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Event;
import com.example.tema1.model.Film;
import com.example.tema1.model.EventModelFactory;
import com.example.tema1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * The type Film controller.
 */
@RestController
@RequestMapping("/filme")
public class FilmController {

    private final FilmService filmService;

    /**
     * Instantiates a new Film controller.
     *
     * @param eventFactory the event factory
     */
    @Autowired
    public FilmController(EventFactory eventFactory) {
        this.filmService = (FilmService) eventFactory.createEvent(EventType.FILM);
    }

    /**
     * Insert filme string.
     *
     * @param film the film
     * @return the string
     */
    @PostMapping("/insert")
    public String insertFilme(@RequestBody Film film){

        return filmService.save(film).toString();
    }

    /**
     * Show filme iterable.
     *
     * @return the iterable
     */
    @GetMapping("/all")
    public Iterable<Film> showFilme(){

        return filmService.findAll();
    }

    /**
     * Find film optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping("/find")
    public Optional<Film> findFilm(@RequestParam Long id){
        return filmService.findById(id);
    }

    /**
     * Delete film.
     *
     * @param id the id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteFilm(@PathVariable("id") Long id){
        filmService.deleteById(id);
    }


    @PutMapping(path = "/update/{id}")
    public Film updateFilm(@PathVariable("id") Long id,
                                 @RequestBody Film film){
        return filmService.updateFilm(id, film);
    }
}
