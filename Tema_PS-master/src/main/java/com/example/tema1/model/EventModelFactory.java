package com.example.tema1.model;

import com.example.tema1.service.EventType;

import java.util.HashSet;

/**
 * The type Event factory.
 */
public class EventModelFactory {

    /**
     * Create event event.
     * cream instante de filme si spectacole pe care le vom folosi pentru a le insera in baza de date
     * @param eventType the event type
     * @return the event
     */
    public Event createEvent(EventType eventType, Event event){
        if(eventType.equals(EventType.FILM)){
            return new Film(event.getNume(), ((Film)event).getGen(), ((Film)event).getVarsta(),
                    ((Film)event).getTip(), event.getData(), ((Film)event).getCapacitate(),
                    ((Film)event).getPret(), ((Film)event).getRegizor(), ((Film)event).getActori(), new HashSet<>());
        }
        if(eventType.equals(EventType.SPECTACOL)){
            return new Spectacol(event.getNume(), ((Spectacol)event).getTip_muzica(), event.getData(),
                    ((Spectacol)event).getPret(), ((Spectacol)event).getArtisti(),
                    ((Spectacol)event).getInterval_orar());
        }
        return null;
    }
}
