package dev.nexus.Potlukk;


import dev.nexus.Repos.PotluckRepo;
import dev.nexus.entities.Potluck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PotluckRepoTests {

    @Autowired
    private PotluckRepo potluckRepo;

    @Test
    public void createPotluck(){
        Potluck potluck = new Potluck(0, "First Potluck", 24000, 1);
        potluckRepo.save(potluck);
        System.out.println(potluck);
        Assertions.assertNotEquals(0, potluck.getId());
    }

    @Test
    public void getAllPotlucks(){
        List<Potluck> potlucks = this.potluckRepo.findAll();
    }

    @Test
    public void getPotluckById(){
        Optional<Potluck> possiblePotluck = this.potluckRepo.findById(1);
        if(possiblePotluck.isPresent()){
            Potluck potluck = possiblePotluck.get();
            System.out.println(potluck);
        }else{
            System.out.println("No potluck returned.");
        }
    }

    @Test
    public void findPotluckByCreator(){
        List<Potluck> potluckList = this.potluckRepo.findPotluckByCreator(1);
        System.out.println(potluckList);
    }

    @Test
    public void changePotluckDate(){
        Potluck potluck = this.potluckRepo.getById(1);
        potluck.setPotluckDate(254000);
    }




    @Test
    public void deletePotluck(){
        this.potluckRepo.deleteById(1);
    }
}
