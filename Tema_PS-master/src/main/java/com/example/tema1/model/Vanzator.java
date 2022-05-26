package com.example.tema1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Vanzator.
 */
@Getter
@Setter
@Entity
public class Vanzator extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nume;
    private String interval_orar;
    private int numar_casa;
    private String username;
    private String password;

    /**
     * Instantiates a new Vanzator.
     *
     * @param nume          the nume
     * @param interval_orar the interval orar
     * @param numar_casa    the numar casa
     * @param username      the username
     * @param password      the password
     */
    public Vanzator(String nume, String interval_orar, int numar_casa, String username, String password) {
        this.nume = nume;
        this.interval_orar = interval_orar;
        this.numar_casa = numar_casa;
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new Vanzator.
     */
    public Vanzator() {

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
     * Gets numar casa.
     *
     * @return the numar casa
     */
    public int getNumar_casa() {
        return numar_casa;
    }

    /**
     * Sets numar casa.
     *
     * @param numar_casa the numar casa
     */
    public void setNumar_casa(int numar_casa) {
        this.numar_casa = numar_casa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Vanzator{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", interval_orar='" + interval_orar + '\'' +
                ", numar_casa=" + numar_casa +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vanzator;
    }
}
