package com.example.tema1.service;

import com.example.tema1.model.Event;
import com.example.tema1.model.EventModelFactory;
import com.example.tema1.model.Film;
import com.example.tema1.model.Spectacol;
import com.example.tema1.repo.SpectacolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

/**
 * The type Spectacol service.
 */
@Service
public class SpectacolService implements EventService, ISpectacolService{

    @Autowired
    private final SpectacolRepository spectacolRepository;

    /**
     * Instantiates a new Spectacol service.
     *
     * @param spectacolRepository the spectacol repository
     */
    public SpectacolService(SpectacolRepository spectacolRepository) {
        this.spectacolRepository = spectacolRepository;
    }

    @Override
    public Spectacol save(Spectacol spectacol) {

        EventModelFactory eventModelFactory = new EventModelFactory();
        Event event1 = spectacol;
        spectacol = (Spectacol) eventModelFactory.createEvent(EventType.SPECTACOL, event1);

        return spectacolRepository.save(spectacol);
    }

    @Override
    public Optional<Spectacol> findById(Long id) {
        if(!spectacolRepository.existsById(id)){
            throw new IllegalStateException("Spectacol with id " + id + " doesn't exist");
        }
        return spectacolRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(!spectacolRepository.existsById(id)){
            throw new IllegalStateException("Spectacol with id " + id + " doesn't exist");
        }
        spectacolRepository.deleteById(id);
    }

    @Override
    public Iterable<Spectacol> findAll() {

        //for(Spectacol s : spectacolRepository.findAll()) {
          //  System.out.println(s.toString());
        //}
        return spectacolRepository.findAll();
    }

    @Override
    public Long count() {
        return spectacolRepository.count();
    }

    /**
     * Update spectacol spectacol.
     * actualizeaza un spectacol din baza de date in functie de field-urile pe care dorim sa le modificam
     * (numele si valorile field-urilor sunt specificate in postman sau in url)
     *
     * @param id     the id
     * @return the spectacol
     */
    @Transactional
    public Spectacol updateSpectacol(Long id, Spectacol spectacol1){
        Spectacol spectacol = spectacolRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Spectacol with id " + id + " doesn't exist"));

        if(!spectacol1.getNume().equals("")){
            spectacol.setNume(spectacol1.getNume());
        }
        if(!spectacol1.getTip_muzica().equals("")){
            spectacol.setTip_muzica(spectacol1.getTip_muzica());
        }
        if(!spectacol1.getArtisti().equals("")){
            spectacol.setArtisti(spectacol1.getArtisti());
        }
        if(!spectacol1.getData().equals("")){
            spectacol.setData(spectacol1.getData());
        }
        if(spectacol1.getPret() != 0){
            spectacol.setPret(spectacol1.getPret());
        }
        if(!spectacol1.getInterval_orar().equals("")){
            spectacol.setInterval_orar(spectacol1.getInterval_orar());
        }

        return spectacolRepository.save(spectacol);
    }
}
