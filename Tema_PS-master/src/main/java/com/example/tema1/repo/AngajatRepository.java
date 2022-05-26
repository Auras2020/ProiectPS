package com.example.tema1.repo;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Angajat repository.
 */
public interface AngajatRepository extends CrudRepository<Angajat, Long> {
}
