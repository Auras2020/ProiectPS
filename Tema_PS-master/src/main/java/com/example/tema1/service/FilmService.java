package com.example.tema1.service;

import com.example.tema1.model.*;
import com.example.tema1.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

/**
 * The type Film service.
 */
@Service
public class FilmService implements EventService, IFilmService{

    @Autowired
    private final FilmRepository filmRepository;

    /**
     * Instantiates a new Film service.
     *
     * @param filmRepository the film repository
     */
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film save(Film film) {

        EventModelFactory eventModelFactory = new EventModelFactory();
        Event event1 = film;
        film = (Film)eventModelFactory.createEvent(EventType.FILM, event1);

        return filmRepository.save(film);
    }

    @Override
    public Optional<Film> findById(Long id) {
        if(!filmRepository.existsById(id)){
            throw new IllegalStateException("Film with id " + id + " doesn't exist");
        }
        return filmRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(!filmRepository.existsById(id)){
            throw new IllegalStateException("Film with id " + id + " doesn't exist");
        }
        filmRepository.deleteById(id);
    }

    @Override
    public Iterable<Film> findAll() {

        //for(Film f : filmRepository.findAll()) {
          //  System.out.println(f.toString());
        //}
        return filmRepository.findAll();
    }

    @Override
    public Long count() {
        return filmRepository.count();
    }


    @Transactional
    public Film updateFilm(Long id, Film film1){
        Film film = filmRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Film with id " + id + " doesn't exist"));

        /*for(Map.Entry<String, String> entry: params.entrySet()){
            if(entry.getKey().equals("nume")){
                film.setNume(entry.getValue());
            }
            else if(entry.getKey().equals("gen")){
                film.setGen(entry.getValue());
            }
            else if(entry.getKey().equals("varsta")){
                int p = 0;
                int nr = 0;
                try{
                    p = Integer.parseInt(entry.getValue());
                }
                catch(NumberFormatException e){
                    nr = 1;
                }
                if(nr == 0){
                    film.setVarsta(p);
                }
                else{
                    System.out.println("Varsta trebuie sa fie un intreg!!!");
                    return null;
                }
            }
            else if(entry.getKey().equals("tip")){
                film.setTip(entry.getValue());
            }
            else if(entry.getKey().equals("data")){
                film.setData(entry.getValue());
            }
            else if(entry.getKey().equals("capacitate")){
                int p = 0;
                int nr = 0;
                try{
                    p = Integer.parseInt(entry.getValue());
                }
                catch(NumberFormatException e){
                    nr = 1;
                }
                if(nr == 0){
                    film.setCapacitate(p);
                }
                else{
                    System.out.println("Capacitatea trebuie sa fie un intreg!!!");
                    return null;
                }
            }
            else if(entry.getKey().equals("pret")){
                int p = 0;
                int nr = 0;
                try{
                    p = Integer.parseInt(entry.getValue());
                }
                catch(NumberFormatException e){
                    nr = 1;
                }
                if(nr == 0){
                    film.setPret(p);
                }
                else{
                    System.out.println("Pretul trebuie sa fie un intreg!!!");
                    return null;
                }
            }
            else if(entry.getKey().equals("regizor")){
                film.setRegizor(entry.getValue());
            }
            else if(entry.getKey().equals("actori")){
                film.setActori(entry.getValue());
            }
            else if(!entry.getKey().equals("id")){
                System.out.println("Cheia/Cheile introduse nu corespund filmului!!!");
                return null;
            }
        }*/

        if(!film1.getActori().equals("")){
            film.setActori(film1.getActori());
        }
        if(film1.getCapacitate() != 0){
            film.setCapacitate(film1.getCapacitate());
        }
        if(!film1.getData().equals("")){
            film.setData(film1.getData());
        }
        if(!film1.getNume().equals("")){
            film.setNume(film1.getNume());
        }
        if(!film1.getGen().equals("")){
            film.setGen(film1.getGen());
        }
        if(film1.getPret() != 0){
            film.setPret(film1.getPret());
        }
        if(!film1.getRegizor().equals("")){
            film.setRegizor(film1.getRegizor());
        }
        if(!film1.getTip().equals("")){
            film.setTip(film1.getTip());
        }
        if(film1.getVarsta() != 0){
            film.setVarsta(film1.getVarsta());
        }
        return filmRepository.save(film);
    }

}
