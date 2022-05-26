package com.example.tema1.service;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.User;
import com.example.tema1.model.UserModelFactory;
import com.example.tema1.repo.AngajatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

/**
 * The type Angajat service.
 */
@Service
public class AngajatService implements UserService, IAngajatService{

    @Autowired
    private final AngajatRepository angajatRepository;

    /**
     * Instantiates a new Angajat service.
     *
     * @param angajatRepository the angajat repository
     */
    public AngajatService(AngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }

    @Override
    public Angajat save(Angajat angajat) {

        UserModelFactory userModelFactory = new UserModelFactory();
        User user1 = angajat;
        angajat = (Angajat) userModelFactory.createUser(UserType.ANGAJAT, user1);

        return angajatRepository.save(angajat);
    }

    @Override
    public Optional<Angajat> findById(Long id) {
        if(!angajatRepository.existsById(id)){
            throw new IllegalStateException("Angajat with id " + id + " doesn't exist");
        }
        return angajatRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(!angajatRepository.existsById(id)){
            throw new IllegalStateException("Angajat with id " + id + " doesn't exist");
        }
        angajatRepository.deleteById(id);
    }

    @Override
    public Iterable<Angajat> findAll() {
        //for(Angajat a : angajatRepository.findAll()) {
          //  System.out.println(a.toString());
        //}
        return angajatRepository.findAll();
    }

    @Override
    public Long count() {
        return angajatRepository.count();
    }

    /**
     * Update angajat angajat.
     * actualizeaza un angajat din baza de date in functie de field-urile pe care dorim sa le modificam
     * (numele si valorile field-urilor sunt specificate in postman sau in url)
     *
     * @param id     the id
     * @param params the params
     * @return the angajat
     */
    @Transactional
    public Angajat updateAngajat(Long id, Map<String, String> params){
        Angajat angajat = angajatRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Angajat with id " + id + " doesn't exist"));

        for(Map.Entry<String, String> entry: params.entrySet()){
            if(entry.getKey().equals("nume")){
                angajat.setNume(entry.getValue());
            }
            else if(entry.getKey().equals("interval_orar")){
                angajat.setInterval_orar(entry.getValue());
            }
            else if(entry.getKey().equals("post_de_munca")){
                int p = 0;
                int nr = 0;
                try{
                    p = Integer.parseInt(entry.getValue());
                }
                catch(NumberFormatException e){
                    nr = 1;
                }
                if(nr == 0){
                    angajat.setPost_de_munca(p);
                }
                else{
                    System.out.println("Postul de munca trebuie sa fie un intreg!!!");
                    return null;
                }
            }
            else if(!entry.getKey().equals("id")){
                System.out.println("Cheia/Cheile introduse nu corespund angajatului!!!");
                return null;
            }
        }

        return angajatRepository.save(angajat);
    }

    /**
     * Login string.
     * daca username-ul si parola indeplinesc constrangerile impuse atunci angajatul va avea acces la
     * baza de date; altfel se vor afisa mesaje de eroare sugestive
     *
     * @param id the id
     * @return the string
     */
    @Transactional
    public String login(Long id){
        Angajat angajat = angajatRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Angajat with id " + id + " doesn't exist"));
        if(angajat.getUsername().length() < 3){
            return "Username should be longer than 2 characters!!";
        }
        if(angajat.getPassword().length() < 5){
            return "Password should be longer than 4 characters!!";
        }
        return "Login credentials are ok!";
    }
}
