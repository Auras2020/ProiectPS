package com.example.tema1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The type Event.
 */
@Getter
@Setter
public class Event {

    private String nume;
    private String data;

    /**
     * Instantiates a new Event.
     *
     * @param nume the nume
     * @param data the data
     */
    public Event(String nume, String data) {
        this.nume = nume;
        this.data = data;
    }

    /**
     * Instantiates a new Event.
     */
    public Event(){

    }

    /**
     * Gets nume.
     *
     * @return the nume
     */
    public String getNume() {
        return nume;
    }

    /**
     * Sets nume.
     *
     * @param nume the nume
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Event;
    }
}
