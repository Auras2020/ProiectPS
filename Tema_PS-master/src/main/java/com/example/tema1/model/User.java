package com.example.tema1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type User.
 */
@Getter
@Setter
//@Entity
public class User {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false)
    //private Long id;

    private String nume;
    private String username;
    private String password;

    /**
     * Instantiates a new User.
     *
     * @param nume     the nume
     * @param username the username
     * @param password the password
     */
    public User(String nume, String username, String password) {
        this.nume = nume;
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     */
    public User(){

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
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
