package dev.nexus.controllers;

import dev.nexus.entities.Potluck;
import dev.nexus.services.PotluckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin("*")
public class PotluckController {

    @Autowired
    public PotluckService potluckService;

    @GetMapping("/potlucks")
    @ResponseBody
    public List<Potluck> retrieveAllPotlucks() {
        List<Potluck> potlucks = this.potluckService.getAllPotlucks();
        return potlucks;
    }

    @GetMapping("/potlucks/{id}")
    @ResponseBody
    public Potluck retrievePotluckById(@PathVariable int id){
        Potluck potluck = this.potluckService.getPotluckById(id);
        return potluck;
    }

    @GetMapping("/users/{creatorId}/potlucks")
    @ResponseBody
    public List<Potluck> retrievePotlucksByCreator(@PathVariable int creatorId){
        List<Potluck> potlucks = this.potluckService.getPotlucksByCreator(creatorId);
        return potlucks;
    }

    @PostMapping("/potlucks")
    @ResponseBody
    public Potluck createNewPotluck(@RequestBody Potluck potluck){
        return this.potluckService.createPotluck(potluck);
    }

    @PatchMapping("/potlucks/{id}/{date}")
    @ResponseBody
    public Potluck createNewPotluck(@PathVariable int id, String date ){

        return this.potluckService.updatePotluckDate(id, date);
    }

    @DeleteMapping("/potlucks/{id}")
    @ResponseBody
    public boolean deletePotluck(@PathVariable int id){
        this.potluckService.deletePotluckById(id);
        return true;
    }

}
