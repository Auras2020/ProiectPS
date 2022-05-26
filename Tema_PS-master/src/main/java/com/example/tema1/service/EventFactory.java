package com.example.tema1.service;

import com.example.tema1.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Event factory.
 */
@Service
public class EventFactory {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SpectacolRepository spectacolRepository;

    /**
     * Create event event service.
     * cream instante de filme si spectacole ale pachetului de service pe care le vom folosi pentru
     * a crea o noua instanta de service in constructorul controller-ului
     *
     * @param eventType the event type
     * @return the event service
     */
    public EventService createEvent(EventType eventType){
        if(eventType.equals(EventType.FILM)){
            return new FilmService(filmRepository);
        }
        if(eventType.equals(EventType.SPECTACOL)){
            return new SpectacolService(spectacolRepository);
        }
        return null;
    }
}
