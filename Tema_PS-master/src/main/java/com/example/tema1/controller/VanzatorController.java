package com.example.tema1.controller;

import com.example.tema1.model.Angajat;
import com.example.tema1.model.User;
import com.example.tema1.model.UserModelFactory;
import com.example.tema1.model.Vanzator;
import com.example.tema1.service.AngajatService;
import com.example.tema1.service.UserFactory;
import com.example.tema1.service.UserType;
import com.example.tema1.service.VanzatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * The type Vanzator controller.
 */
@RestController
@RequestMapping("vanzatori")
public class VanzatorController {

    private final VanzatorService vanzatorService;

    /**
     * Instantiates a new Vanzator controller.
     *
     * @param userFactory the user factory
     */
    @Autowired
    public VanzatorController(UserFactory userFactory){
        this.vanzatorService = (VanzatorService) userFactory.createUser(UserType.VANZATOR);
    }

    /**
     * Insert vanzatori string.
     *
     * @param vanzator the vanzator
     * @return the string
     */
    @PostMapping("/insert")
    public String insertVanzatori(@RequestBody Vanzator vanzator){

        return vanzatorService.save(vanzator).toString();
    }

    /**
     * Show clienti iterable.
     *
     * @return the iterable
     */
    @GetMapping("/all")
    public Iterable<Vanzator> showVanzatori(){

        return vanzatorService.findAll();
    }

    /**
     * Find vanzator optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping("/find")
    public Optional<Vanzator> findVanzator(@RequestParam Long id){
        return vanzatorService.findById(id);
    }

    /**
     * Delete vanzator.
     *
     * @param id the id
     */
    @DeleteMapping("/delete")
    public void deleteVanzator(@RequestParam Long id){
        vanzatorService.deleteById(id);
    }

    /**
     * Update vanzator vanzator.
     *
     * @param id     the id
     * @param params the params
     * @return the vanzator
     */
    @PutMapping("/update")
    public Vanzator updateVanzator(@RequestParam(required = false) Long id,
                                 @RequestParam(required = false) Map<String, String> params){
        return vanzatorService.updateVanzator(id, params);
    }

    /**
     * Login vanzator string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/login")
    public String loginVanzator(@RequestParam Long id){
        return vanzatorService.login(id);
    }
}
