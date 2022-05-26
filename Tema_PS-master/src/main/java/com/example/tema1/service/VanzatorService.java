package com.example.tema1.service;

import com.example.tema1.model.*;
import com.example.tema1.repo.VanzatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

/**
 * The type Vanzator service.
 */
@Service
public class VanzatorService implements UserService, IVanzatorService{

    @Autowired
    private final VanzatorRepository vanzatorRepository;

    /**
     * Instantiates a new Vanzator service.
     *
     * @param vanzatorRepository the vanzator repository
     */
    public VanzatorService(VanzatorRepository vanzatorRepository) {
        this.vanzatorRepository = vanzatorRepository;
    }

    @Override
    public Vanzator save(Vanzator vanzator) {

        UserModelFactory userModelFactory = new UserModelFactory();
        User user1 = vanzator;
        vanzator = (Vanzator) userModelFactory.createUser(UserType.VANZATOR, user1);

        return vanzatorRepository.save(vanzator);
    }

    @Override
    public Optional<Vanzator> findById(Long id) {
        if(!vanzatorRepository.existsById(id)){
            throw new IllegalStateException("Vanzator with id " + id + " doesn't exist");
        }
        return vanzatorRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(!vanzatorRepository.existsById(id)){
            throw new IllegalStateException("Vanzator with id " + id + " doesn't exist");
        }
        vanzatorRepository.deleteById(id);
    }

    @Override
    public Iterable<Vanzator> findAll() {

       // for(Vanzator v : vanzatorRepository.findAll()) {
         //   System.out.println(v.toString());
        //}
        return vanzatorRepository.findAll();
    }

    @Override
    public Long count() {
        return vanzatorRepository.count();
    }

    /**
     * Update vanzator vanzator.
     *
     * @param id     the id
     * @param params the params
     * @return the vanzator
     */
    @Transactional
    public Vanzator updateVanzator(Long id, Map<String, String> params){
        Vanzator vanzator = vanzatorRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Client with id " + id + " doesn't exist"));

        for(Map.Entry<String, String> entry: params.entrySet()){
            if(entry.getKey().equals("nume")){
                vanzator.setNume(entry.getValue());
            }
            else if(entry.getKey().equals("interval_orar")){
                vanzator.setInterval_orar(entry.getValue());
            }
            else if(entry.getKey().equals("numar_casa")){
                int p = 0;
                int nr = 0;
                try{
                    p = Integer.parseInt(entry.getValue());
                }
                catch(NumberFormatException e){
                    nr = 1;
                }
                if(nr == 0){
                    vanzator.setNumar_casa(p);
                }
                else{
                    System.out.println("Numarul casei trebuie sa fie un intreg!!!");
                    return null;
                }
            }
            else if(!entry.getKey().equals("id")){
                System.out.println("Cheia/Cheile introduse nu corespund vanzatorului!!!");
                return null;
            }
        }

        return vanzatorRepository.save(vanzator);
    }

    /**
     * Login string.
     * daca username-ul si parola indeplinesc constrangerile impuse atunci vanzatorul va avea acces la
     * baza de date; altfel se vor afisa mesaje de eroare sugestive
     *
     * @param id the id
     * @return the string
     */
    @Transactional
    public String login(Long id){
        Vanzator vanzator = vanzatorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Vanzator with id " + id + " doesn't exist"));
        if(vanzator.getUsername().length() < 3){
            return "Username should be longer than 2 characters!!";
        }
        if(vanzator.getPassword().length() < 5){
            return "Password should be longer than 4 characters!!";
        }
        return "Login credentials are ok!";
    }
}
