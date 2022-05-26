package com.example.tema1.controller;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.Client;
import com.example.tema1.model.User;
import com.example.tema1.model.UserModelFactory;
import com.example.tema1.service.ClientService;
import com.example.tema1.service.UserFactory;
import com.example.tema1.service.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * The type Client controller.
 */
@RestController
@RequestMapping("/clienti")
public class ClientController {

    private final ClientService clientService;

    /**
     * Instantiates a new Client controller.
     *
     * @param userFactory the user factory
     */
    @Autowired
    public ClientController(UserFactory userFactory) {
        this.clientService = (ClientService) userFactory.createUser(UserType.CLIENT);
    }

    /**
     * Insert clienti string.
     *
     * @param client the client
     * @return the string
     */
    @PostMapping("/insert")
    public String insertClienti(@RequestBody Client client){

        return clientService.save(client).toString();
    }

    /**
     * Show clienti iterable.
     *
     * @return the iterable
     */
    @GetMapping("/all")
    public Iterable<Client> showClienti(){

        return clientService.findAll();
    }

    /**
     * Find client optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping("/find")
    public Optional<Client> findClient(@RequestParam Long id){
        return clientService.findById(id);
    }

    /**
     * Delete client.
     *
     * @param id the id
     */
    @DeleteMapping("/delete")
    public void deleteClient(@RequestParam Long id){
        clientService.deleteById(id);
    }

    /**
     * Update angajat client.
     *
     * @param id     the id
     * @param params the params
     * @return the client
     */
    @PutMapping("/update")
    public Client updateAngajat(@RequestParam(required = false) Long id,
                                 @RequestParam(required = false) Map<String, String> params){
        return clientService.updateClient(id, params);
    }

    /**
     * Login client string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/login")
    public String loginClient(@RequestParam Long id){
        return clientService.login(id);
    }
}
