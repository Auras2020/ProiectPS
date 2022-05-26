package com.example.tema1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * The type Film.
 */
@Getter
@Setter
@Entity
//@Table(name = "film")
public class Film extends Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private Long id;

    private String nume;
    private String gen;
    private int varsta;
    private String tip;
    private String data;
    private int capacitate;
    private int pret;
    private String regizor;
    private String actori;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(name="bilete_filme",
            joinColumns = @JoinColumn(name="film_id"),
            inverseJoinColumns = @JoinColumn(name="client_id"))
    private Set<Client> clients;

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

    /**
     * Instantiates a new Film.
     */
    public Film() {

    }

    /**
     * Instantiates a new Film.
     *
     * @param nume       the nume
     * @param gen        the gen
     * @param varsta     the varsta
     * @param tip        the tip
     * @param data       the data
     * @param capacitate the capacitate
     * @param pret       the pret
     * @param regizor    the regizor
     * @param actori     the actori
     */
    public Film(String nume, String gen, int varsta, String tip, String data, int capacitate, int pret, String regizor, String actori,
                Set<Client> clients) {
        this.nume = nume;
        this.gen = gen;
        this.varsta = varsta;
        this.tip = tip;
        this.data = data;
        this.capacitate = capacitate;
        this.pret = pret;
        this.regizor = regizor;
        this.actori = actori;
        this.clients = clients;
    }


    /**
     * Gets gen.
     *
     * @return the gen
     */
    public String getGen() {
        return gen;
    }

    /**
     * Sets gen.
     *
     * @param gen the gen
     */
    public void setGen(String gen) {
        this.gen = gen;
    }

    /**
     * Gets varsta.
     *
     * @return the varsta
     */
    public int getVarsta() {
        return varsta;
    }

    /**
     * Sets varsta.
     *
     * @param varsta the varsta
     */
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    /**
     * Gets tip.
     *
     * @return the tip
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets tip.
     *
     * @param tip the tip
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * Gets capacitate.
     *
     * @return the capacitate
     */
    public int getCapacitate() {
        return capacitate;
    }

    /**
     * Sets capacitate.
     *
     * @param capacitate the capacitate
     */
    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    /**
     * Gets pret.
     *
     * @return the pret
     */
    public int getPret() {
        return pret;
    }

    /**
     * Sets pret.
     *
     * @param pret the pret
     */
    public void setPret(int pret) {
        this.pret = pret;
    }

    /**
     * Gets regizor.
     *
     * @return the regizor
     */
    public String getRegizor() {
        return regizor;
    }

    /**
     * Sets regizor.
     *
     * @param regizor the regizor
     */
    public void setRegizor(String regizor) {
        this.regizor = regizor;
    }

    /**
     * Gets actori.
     *
     * @return the actori
     */
    public String getActori() {
        return actori;
    }

    /**
     * Sets actori.
     *
     * @param actori the actori
     */
    public void setActori(String actori) {
        this.actori = actori;
    }

    /**
     * Gets clients.
     *
     * @return the clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Sets clients.
     *
     * @param clients the clients
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", gen='" + gen + '\'' +
                ", varsta=" + varsta +
                ", tip='" + tip + '\'' +
                ", data='" + data + '\'' +
                ", capacitate=" + capacitate +
                ", pret=" + pret +
                ", regizor='" + regizor + '\'' +
                ", actori='" + actori + '\'' +
                '}' ;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Film;
    }
}
