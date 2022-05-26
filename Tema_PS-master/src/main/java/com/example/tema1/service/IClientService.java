package com.example.tema1.service;

import com.example.tema1.model.Client;
import com.sun.mail.imap.protocol.ID;

import java.util.List;
import java.util.Optional;

/**
 * The interface Client service.
 */
public interface IClientService {
    /**
     * Save client.
     *
     * @param client the client
     * @return the client
     */
    Client save(Client client);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Client> findById(Long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

    /**
     * Find all iterable.
     *
     * @return the iterable
     */
    Iterable<Client> findAll();

    /**
     * Count long.
     *
     * @return the long
     */
    Long count();
}
