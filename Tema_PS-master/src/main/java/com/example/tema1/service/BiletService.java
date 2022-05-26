package com.example.tema1.service;

import com.example.tema1.model.Bilet;
import com.example.tema1.model.Client;
import com.example.tema1.model.Film;
import com.example.tema1.model.Spectacol;
import com.example.tema1.repo.ClientRepository;
import com.example.tema1.repo.FilmRepository;
import com.example.tema1.repo.SpectacolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The type Bilet service.
 */
@Service
public class BiletService{

    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final FilmRepository filmRepository;
    @Autowired
    private final SpectacolRepository spectacolRepository;

    /**
     * Instantiates a new Bilet service.
     *
     * @param clientRepository    the client repository
     * @param filmRepository      the film repository
     * @param spectacolRepository the spectacol repository
     */
    public BiletService(ClientRepository clientRepository, FilmRepository filmRepository,
                        SpectacolRepository spectacolRepository) {
        this.clientRepository = clientRepository;
        this.filmRepository = filmRepository;
        this.spectacolRepository = spectacolRepository;
    }

    /**
     * Create bilet film bilet.
     *
     * @param idClient the id client
     * @param idFilm   the id film
     * @return the bilet
     */
    @Transactional
    public Bilet createBiletFilm(Long idClient, Long idFilm){

        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new IllegalStateException("Client with id " + idClient + " doesn't exist"));
        Film film = filmRepository.findById(idFilm).
                orElseThrow(() -> new IllegalStateException("Film with id " + idFilm + " doesn't exist"));

        client.getFilms().add(film);
        film.getClients().add(client);

        clientRepository.save(client);
        filmRepository.save(film);

        return new Bilet(client.getFilms().size() + client.getSpectacole().size(), client.getNume(), film.getNume());

    }

    /**
     * Create bilet spectacol bilet.
     *
     * @param idClient    the id client
     * @param idSpectacol the id spectacol
     * @return the bilet
     */
    @Transactional
    public Bilet createBiletSpectacol(Long idClient, Long idSpectacol){

        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new IllegalStateException("Client with id " + idClient + " doesn't exist"));
        Spectacol spectacol = spectacolRepository.findById(idSpectacol).
                orElseThrow(() -> new IllegalStateException("Spectacol with id " + idSpectacol + " doesn't exist"));

        client.getSpectacole().add(spectacol);
        spectacol.getClients1().add(client);

        clientRepository.save(client);
        spectacolRepository.save(spectacol);

        return new Bilet(client.getFilms().size() + client.getSpectacole().size(), client.getNume(), spectacol.getNume());

    }

}
