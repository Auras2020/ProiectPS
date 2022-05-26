package com.example.tema1.model;

/**
 * The type Bilet.
 */
public class Bilet {

    private int numarBilet;
    private String client;
    private String event;

    /**
     * Instantiates a new Bilet.
     *
     * @param numarBilet the numar bilet
     * @param client     the client
     * @param event      the event
     */
    public Bilet(int numarBilet, String client, String event) {
        this.numarBilet = numarBilet;
        this.client = client;
        this.event = event;
    }

    /**
     * Gets numar bilet.
     *
     * @return the numar bilet
     */
    public int getNumarBilet() {
        return numarBilet;
    }

    /**
     * Sets numar bilet.
     *
     * @param numarBilet the numar bilet
     */
    public void setNumarBilet(int numarBilet) {
        this.numarBilet = numarBilet;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Gets event.
     *
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "numarBilet=" + numarBilet +
                ", client='" + client + '\'' +
                ", event='" + event + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Bilet;
    }
}
