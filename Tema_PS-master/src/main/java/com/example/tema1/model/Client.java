package com.example.tema1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * The type Client.
 */
@Getter
@Setter
@Entity
//@Table(name = "client")
public class Client extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Long id;

    private String nume;
    private int varsta;
    private String certificatVerde;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy="clients")
    //@JsonManagedReference
    private Set<Film> films;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy="clients1")
    //@JsonManagedReference
    private Set<Spectacol> spectacole;

    /**
     * Instantiates a new Client.
     *
     * @param nume            the nume
     * @param varsta          the varsta
     * @param certificatVerde the certificat verde
     * @param username        the username
     * @param password        the password
     */
    public Client(String nume, int varsta, String certificatVerde, String username, String password) {
        this.nume = nume;
        this.varsta = varsta;
        this.certificatVerde = certificatVerde;
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new Client.
     */
    public Client() {

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
     * Gets certificat verde.
     *
     * @return the certificat verde
     */
    public String getCertificatVerde() {
        return certificatVerde;
    }

    /**
     * Sets certificat verde.
     *
     * @param certificatVerde the certificat verde
     */
    public void setCertificatVerde(String certificatVerde) {
        this.certificatVerde = certificatVerde;
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

    /**
     * Gets films.
     *
     * @return the films
     */
    public Set<Film> getFilms() {
        return films;
    }

    /**
     * Sets films.
     *
     * @param films the films
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    /**
     * Gets spectacole.
     *
     * @return the spectacole
     */
    public Set<Spectacol> getSpectacole() {
        return spectacole;
    }

    /**
     * Sets spectacole.
     *
     * @param spectacole the spectacole
     */
    public void setSpectacole(Set<Spectacol> spectacole) {
        this.spectacole = spectacole;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", certificatVerde='" + certificatVerde + '\'' +
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
        return obj instanceof Client;
    }
}
