package com.example.tema1.service;

import com.example.tema1.repo.AngajatRepository;
import com.example.tema1.repo.ClientRepository;
import com.example.tema1.repo.VanzatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User factory.
 */
@Service
public class UserFactory {

    @Autowired
    private AngajatRepository angajatRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VanzatorRepository vanzatorRepository;

    /**
     * Create user user service.
     * cream instante de clienti, angajati si vanzatori ale pachetului de service pe care le vom folosi
     * pentru a crea o noua instanta de service in constructorul controller-ului
     *
     * @param userType the user type
     * @return the user service
     */
    public UserService createUser(UserType userType){
        if(userType.equals(UserType.CLIENT)){
            return new ClientService(clientRepository);
        }
        if(userType.equals(UserType.ANGAJAT)){
            return new AngajatService(angajatRepository);
        }
        if(userType.equals(UserType.VANZATOR)){
            return new VanzatorService(vanzatorRepository);
        }
        return null;
    }
}
