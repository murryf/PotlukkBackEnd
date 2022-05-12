package dev.nexus.Potlukk;


import dev.nexus.entities.Item;
import dev.nexus.repos.ItemRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemRepoTests {

    static Item testItem = null;

    @Autowired
    private ItemRepo itemRepo;

    @Test
    public void createItem(){
        Item testItem = new Item(0,"Potato Salad", "Jill's famous purple potato salad",
                "Covered", "Jill", 9001);
        System.out.println(testItem);
        itemRepo.save(testItem);
        Assertions.assertNotEquals(0,testItem.getId());
    }

    @Test
    public void getItemById(){
        Optional<Item> possibleItem = this.itemRepo.findById(2);
        if(possibleItem.isPresent()){
            Item localItem = possibleItem.get();
            Assertions.assertEquals(2,localItem.getId());
        }
    }

    @Test
    public void getAllItems(){
        List<Item> items = this.itemRepo.findAll();
        Assertions.assertNotNull(items);
    }

    @Test
    public void updateItem(){
        Item newItem = new Item(5,"Tater tots","crispy", "Wanted","You?", 2);
        this.itemRepo.save(newItem);
    }

    @Test
    public void deleteItembyid(){
        this.itemRepo.deleteById(1);
    }


    @Test
    public void deleteItemsByPotluck() {
        List<Item> items = this.itemRepo.findAll();
        System.out.println(items);
        items.removeIf(item -> item.getPotluckID() != 9001);
        System.out.println(items);
        this.itemRepo.deleteAllInBatch(items);

    }
}
