package com.example.tema1.controller;

import com.example.tema1.model.*;
import com.example.tema1.service.AngajatService;
import com.example.tema1.service.EventType;
import com.example.tema1.service.UserFactory;
import com.example.tema1.service.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * The type Angajat controller.
 */
@RestController
@RequestMapping("angajati")
public class AngajatController {

    private final AngajatService angajatService;

    /**
     * Instantiates a new Angajat controller.
     *
     * @param userFactory the user factory
     */
    @Autowired
    public AngajatController(UserFactory userFactory){
        this.angajatService = (AngajatService) userFactory.createUser(UserType.ANGAJAT);
    }

    /**
     * Insert angajati string.
     *
     * @param angajat the angajat
     * @return the string
     */
    @PostMapping("/insert")
    public String insertAngajati(@RequestBody Angajat angajat){

        return angajatService.save(angajat).toString();
    }

    /**
     * Show clienti iterable.
     *
     * @return the iterable
     */
    @GetMapping("/all")
    public Iterable<Angajat> showAngajati(){

        return angajatService.findAll();
    }

    /**
     * Find angajat optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping("/find")
    public Optional<Angajat> findAngajat(@RequestParam Long id){
        return angajatService.findById(id);
    }

    /**
     * Delete angajat.
     *
     * @param id the id
     */
    @DeleteMapping("/delete")
    public void deleteAngajat(@RequestParam Long id){
        angajatService.deleteById(id);
    }

    /**
     * Update angajat angajat.
     *
     * @param id     the id
     * @param params the params
     * @return the angajat
     */
    @PutMapping("/update")
    public Angajat updateAngajat(@RequestParam(required = false) Long id,
                                 @RequestParam(required = false) Map<String, String> params){
        return angajatService.updateAngajat(id, params);
    }

    /**
     * Login angajat string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/login")
    public String loginAngajat(@RequestParam Long id){
        return angajatService.login(id);
    }
}
