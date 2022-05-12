package dev.nexus.Potlukk;

import dev.nexus.entities.Potluck;
import dev.nexus.services.PotluckService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PotluckServiceTests {

    @Autowired
    private PotluckService potluckService;

    static Potluck testpotluck = null;


    @Test
    public void createPotluck(){
        Potluck potluck = this.potluckService.createPotluck(new Potluck(0,"Fourth", "Please Set Date", 1));
        System.out.println(potluck);
    }

    @Test
    public void getAllPotlucks(){
        List<Potluck> potlucks = this.potluckService.getAllPotlucks();
        System.out.println(potlucks);
    }

    @Test
    public void getPotluckById(){
        Potluck potluck = this.potluckService.getPotluckById(9);
        System.out.println(potluck);
    }

    @Test
    public void getPotlucksByCreator(){
        List<Potluck> potlucks = this.potluckService.getPotlucksByCreator(1);
        System.out.println(potlucks);
    }

    @Test
    public void changePotluckDate(){
        this.potluckService.updatePotluckDate(2, "This is a new Service Date");
    }

    @Test
    public void deletePotluckById(){
        this.potluckService.deletePotluckById(9);
    }

}
