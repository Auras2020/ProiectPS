package com.example.tema1.service;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Client;
import com.example.tema1.model.User;
import com.example.tema1.model.UserModelFactory;
import com.example.tema1.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

/**
 * The type Client service.
 */
@Service
public class ClientService implements UserService, IClientService{

    @Autowired
    private final ClientRepository clientRepository;

    /**
     * Instantiates a new Client service.
     *
     * @param clientRepository the client repository
     */
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {

        UserModelFactory userModelFactory = new UserModelFactory();
        User user1 = client;
        client = (Client) userModelFactory.createUser(UserType.CLIENT, user1);



        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        if(!clientRepository.existsById(id)){
            throw new IllegalStateException("Client with id " + id + " doesn't exist");
        }
        return clientRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(!clientRepository.existsById(id)){
            throw new IllegalStateException("Client with id " + id + " doesn't exist");
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Iterable<Client> findAll() {

        //for(Client c : clientRepository.findAll()) {
          //  System.out.println(c.toString());
        //}
        return clientRepository.findAll();
    }

    @Override
    public Long count() {
        return clientRepository.count();
    }

    /**
     * Update client client.
     * actualizeaza un client din baza de date in functie de field-urile pe care dorim sa le modificam
     * (numele si valorile field-urilor sunt specificate in postman sau in url)
     *
     * @param id     the id
     * @param params the params
     * @return the client
     */
    @Transactional
    public Client updateClient(Long id, Map<String, String> params){
        Client client = clientRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Client with id " + id + " doesn't exist"));

        for(Map.Entry<String, String> entry: params.entrySet()){
            if(entry.getKey().equals("nume")){
                client.setNume(entry.getValue());
            }
            else if(entry.getKey().equals("varsta")){
                int p = 0;
                int nr = 0;
                try{
                    p = Integer.parseInt(entry.getValue());
                }
                catch(NumberFormatException e){
                    nr = 1;
                }
                if(nr == 0){
                    client.setVarsta(p);
                }
                else{
                    System.out.println("Varsta trebuie sa fie un intreg!!!");
                    return null;
                }
            }
            else if(entry.getKey().equals("certificat_verde")){
                client.setCertificatVerde(entry.getValue());
            }
            else if(!entry.getKey().equals("id")){
                System.out.println("Cheia/Cheile introduse nu corespund clientului!!!");
                return null;
            }
        }

        return clientRepository.save(client);
    }

    /**
     * Login string.
     * daca username-ul si parola indeplinesc constrangerile impuse atunci clientul va avea acces la
     * baza de date; altfel se vor afisa mesaje de eroare sugestive
     *
     * @param id the id
     * @return the string
     */
    @Transactional
    public String login(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Client with id " + id + " doesn't exist"));
        if(client.getUsername().length() < 3){
            return "Username should be longer than 2 characters!!";
        }
        if(client.getPassword().length() < 5){
            return "Password should be longer than 4 characters!!";
        }
        return "Login credentials are ok!";
    }
}
