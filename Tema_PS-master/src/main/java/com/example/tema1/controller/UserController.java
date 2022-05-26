package com.example.tema1.controller;

import com.example.tema1.model.*;
import com.example.tema1.service.AngajatService;
import com.example.tema1.service.ClientService;
import com.example.tema1.service.VanzatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller.
 */
/*@RestController
@RequestMapping("/users")
public class UserController {

    private static ClientService clientService;
    private static AngajatService angajatService;
    private static VanzatorService vanzatorService;
    private UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param clientService   the client service
     * @param angajatService  the angajat service
     * @param vanzatorService the vanzator service
     * @param userService     the user service
     */
   /* @Autowired
    public UserController(ClientService clientService, AngajatService angajatService, VanzatorService vanzatorService, UserService userService) {
        this.clientService = clientService;
        this.angajatService = angajatService;
        this.vanzatorService = vanzatorService;
        this.userService = userService;
    }

    /**
     * Insert client string.
     *
     * @param client the client
     * @return the string
     */
   /* @PostMapping("/insert/client")
    public String insertClient(@RequestBody Client client){
        return clientService.save(client).toString();
    }

    /**
     * Insert client factory string.
     * inseram clientul creat in clasa de Factory(UserFactory)
     * @param client the client
     * @return the string
     */
   /* @PostMapping("/insert/client/factory")
    public String insertClientFactory(@RequestBody Client client){
        UserFactory userFactory = new UserFactory();
        client = (Client) userFactory.createUser(UserType.CLIENT);

        return clientService.save(client).toString();
    }

    /**
     * Insert angajat string.
     *
     * @param angajat the angajat
     * @return the string
     */
   /* @PostMapping("/insert/angajat")
    public String insertAngajat(@RequestBody Angajat angajat){
        return angajatService.save(angajat).toString();
    }

    /**
     * Insert angajat factory string.
     * inseram angajatul creat in clasa de Factory(UserFactory)
     * @param angajat the angajat
     * @return the string
     */
   /* @PostMapping("/insert/angajat/factory")
    public String insertAngajatFactory(@RequestBody Angajat angajat){
        UserFactory userFactory = new UserFactory();
        angajat = (Angajat) userFactory.createUser(UserType.ANGAJAT);

        return angajatService.save(angajat).toString();
    }

    /**
     * Insert vanzator string.
     *
     * @param vanzator the vanzator
     * @return the string
     */
   /* @PostMapping("/insert/vanzator")
    public String insertVanzator(@RequestBody Vanzator vanzator){
        return vanzatorService.save(vanzator).toString();
    }

    /**
     * Insert vanzator factory string.
     * inseram vanzatorul creat in clasa de Factory(UserFactory)
     * @param vanzator the vanzator
     * @return the string
     */
   /* @PostMapping("/insert/vanzator/factory")
    public String insertVanzatorFactory(@RequestBody Vanzator vanzator){
        UserFactory userFactory = new UserFactory();
        vanzator = (Vanzator) userFactory.createUser(UserType.VANZATOR);

        return vanzatorService.save(vanzator).toString();
    }

    /**
     * Show users iterable.
     * afisam toti userii din baza de date(clienti, angajati, vanzatori)
     * @return the iterable
     */
   /* @GetMapping("/all")
    public Iterable<User> showUsers(){
        for(User u : userService.findAll()){
            System.out.println(u.toString());
        }
        return userService.findAll();
    }

    /**
     * Show clienti iterable.
     * afisam clientii din baza de date
     * @return the iterable
     */
   /* @GetMapping("/all/clienti")
    public Iterable<Client> showClienti(){
        for(User u: userService.findAll()){
            if(u instanceof Client){
                System.out.println(u.toString());
            }
        }
        return clientService.findAll();
    }

    /**
     * Show angajati iterable.
     * afisam angajatii din baza de date
     * @return the iterable
     */
  /*  @GetMapping("/all/angajati")
    public Iterable<Angajat> showAngajati(){
        for(User u: userService.findAll()){
            if(u instanceof Angajat){
                System.out.println(u.toString());
            }
        }
        return angajatService.findAll();
    }

    /**
     * Show vanzatori iterable.
     * afisam vanzatorii din baza de date
     * @return the iterable
     */
   /* @GetMapping("/all/vanzatori")
    public Iterable<Vanzator> showVanzatori(){
        for(User u: userService.findAll()){
            if(u instanceof Vanzator){
                System.out.println(u.toString());
            }
        }
        return vanzatorService.findAll();
    }

    /**
     * Gets client service.
     *
     * @return the client service
     */
   /* public static ClientService getClientService() {
        return clientService;
    }

    /**
     * Sets client service.
     *
     * @param clientService the client service
     */
   /* public static void setClientService(ClientService clientService) {
        UserController.clientService = clientService;
    }

    /**
     * Gets angajat service.
     *
     * @return the angajat service
     */
   /* public static AngajatService getAngajatService() {
        return angajatService;
    }

    /**
     * Sets angajat service.
     *
     * @param angajatService the angajat service
     */
   /* public static void setAngajatService(AngajatService angajatService) {
        UserController.angajatService = angajatService;
    }

    /**
     * Gets vanzator service.
     *
     * @return the vanzator service
     */
   /* public static VanzatorService getVanzatorService() {
        return vanzatorService;
    }

    /**
     * Sets vanzator service.
     *
     * @param vanzatorService the vanzator service
     */
   /* public static void setVanzatorService(VanzatorService vanzatorService) {
        UserController.vanzatorService = vanzatorService;
    }
}*/
