package com.example.tema1.model;

import com.example.tema1.service.UserType;

/**
 * The type User factory.
 */
public class UserModelFactory {
    /**
     * Create user user.
     * cream instante de angajati, clienti si vanzatori pe care le vom folosi pentru a le insera in baza de date
     * @param userType the user type
     * @return the user
     */
    public User createUser(UserType userType, User user){
        if(userType.equals(UserType.ANGAJAT)){
            return new Angajat(user.getNume(), ((Angajat)user).getInterval_orar(), ((Angajat)user).getPost_de_munca(),
                    user.getUsername(), user.getPassword());
        }
        if(userType.equals(UserType.CLIENT)){
            return new Client(user.getNume(), ((Client)user).getVarsta(), ((Client)user).getCertificatVerde(),
                    user.getUsername(), user.getPassword());
        }
        if(userType.equals(UserType.VANZATOR)){
            return new Vanzator(user.getNume(), ((Vanzator)user).getInterval_orar(), ((Vanzator)user).getNumar_casa(),
                    user.getUsername(), user.getPassword());
        }
        return null;
    }
}
