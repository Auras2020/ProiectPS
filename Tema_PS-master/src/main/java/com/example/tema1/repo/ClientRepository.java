package com.example.tema1.repo;

import com.example.tema1.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Client repository.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
}
