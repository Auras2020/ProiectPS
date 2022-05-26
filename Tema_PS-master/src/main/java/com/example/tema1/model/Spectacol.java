package com.example.tema1.model;

import com.example.tema1.controller.SpectacolController;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * The type Spectacol.
 */
@Getter
@Setter
@Entity
public class Spectacol extends Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spectacol_id", nullable = false)
    private Long id;

    private String nume;
    private String tip_muzica;
    private String data;
    private int pret;
    private String artisti;
    private String interval_orar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(name="bilete_spectacole",
            joinColumns = @JoinColumn(name="spectacol_id"),
            inverseJoinColumns = @JoinColumn(name="client_id"))
    private Set<Client> clients1;

    /**
     * Instantiates a new Spectacol.
     *
     * @param nume          the nume
     * @param tip_muzica    the tip muzica
     * @param data          the data
     * @param artisti       the artisti
     * @param interval_orar the interval orar
     */
    public Spectacol(String nume, String tip_muzica, String data, int pret, String artisti, String interval_orar) {
        this.nume = nume;
        this.tip_muzica = tip_muzica;
        this.data = data;
        this.pret = pret;
        this.artisti = artisti;
        this.interval_orar = interval_orar;
    }

    /**
     * Instantiates a new Spectacol.
     */
    public Spectacol() {

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * Gets tip muzica.
     *
     * @return the tip muzica
     */
    public String getTip_muzica() {
        return tip_muzica;
    }

    /**
     * Sets tip muzica.
     *
     * @param tip_muzica the tip muzica
     */
    public void setTip_muzica(String tip_muzica) {
        this.tip_muzica = tip_muzica;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    /**
     * Gets artisti.
     *
     * @return the artisti
     */
    public String getArtisti() {
        return artisti;
    }

    /**
     * Sets artisti.
     *
     * @param artisti the artisti
     */
    public void setArtisti(String artisti) {
        this.artisti = artisti;
    }

    /**
     * Gets interval orar.
     *
     * @return the interval orar
     */
    public String getInterval_orar() {
        return interval_orar;
    }

    /**
     * Sets interval orar.
     *
     * @param interval_orar the interval orar
     */
    public void setInterval_orar(String interval_orar) {
        this.interval_orar = interval_orar;
    }

    /**
     * Gets clients 1.
     *
     * @return the clients 1
     */
    public Set<Client> getClients1() {
        return clients1;
    }

    /**
     * Sets clients 1.
     *
     * @param clients1 the clients 1
     */
    public void setClients1(Set<Client> clients1) {
        this.clients1 = clients1;
    }

    @Override
    public String toString() {
        return "Spectacol{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", tip_muzica='" + tip_muzica + '\'' +
                ", data='" + data + '\'' +
                ", pret='" + pret + '\'' +
                ", artisti='" + artisti + '\'' +
                ", interval_orar='" + interval_orar + '\'' +
                '}' ;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Spectacol;
    }
}
