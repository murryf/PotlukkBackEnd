package dev.nexus.Potlukk;



import dev.nexus.repos.ItemRepo;
import dev.nexus.repos.PotluckRepo;
import dev.nexus.entities.Potluck;
import dev.nexus.services.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PotluckRepoTests {

    static Potluck testPotluck = null;

    @Autowired
    private PotluckRepo potluckRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemService itemService;

    @Test
    @Order(1)
    public void createPotluck(){
        Potluck potluck = new Potluck(0, "First Potluck", "Not Ready Yet", 2);
        potluckRepo.save(potluck);
        testPotluck = potluck;
        System.out.println(potluck);
        Assertions.assertNotEquals(0, potluck.getId());
    }

    @Test
    @Order(2)
    public void getAllPotlucks(){
        List<Potluck> potlucks = this.potluckRepo.findAll();
    }

    @Test
    @Order(3)
    public void getPotluckById(){
        Optional<Potluck> possiblePotluck = this.potluckRepo.findById(2);
        if(possiblePotluck.isPresent()){
            Potluck potluck = possiblePotluck.get();
            System.out.println(potluck);
        }else{
            System.out.println("No potluck returned.");
        }
    }

    @Test
    @Order(4)
    public void findPotluckByCreator(){
        List<Potluck> potluckList = this.potluckRepo.findPotluckByCreator(1);
        System.out.println(potluckList);
    }


    @Test
    @Order(5)
    public void updatePotluckById(){
        Optional<Potluck> possiblePotluck = this.potluckRepo.findById(2);
        if(possiblePotluck.isPresent()){
            Potluck potluck = possiblePotluck.get();
            potluck.setPotluckDate("N/A");
            this.potluckRepo.save(potluck);
            System.out.println(potluck);
        }else{
            System.out.println("No potluck returned.");
        }
    }


    @Test
    @Order(6)
    public void deletePotluck(){
        this.potluckRepo.deleteById(2);
    }

    @Test
    @Order(6)
    public void deleteAllPotlucks(){
        int potluckID = 9001;

        this.itemService.deleteItemsByPotluck(potluckID);

        List<Potluck> potlucks = this.potluckRepo.findAll();
        potlucks.removeIf(potluck -> potluck.getId() != potluckID);
        this.potluckRepo.deleteAllInBatch(potlucks);

    }

}
