package dev.nexus.Potlukk;


import dev.nexus.entities.Item;
import dev.nexus.services.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemServiceTests {

    @Autowired
    private ItemService itemService;

    static Item testItem = null;


    @Test
    public void createItem(){
        Item item = this.itemService.registerItem(new Item(1,"Chicken Salad",
                "With crasins", "wanted","",2));
        Assertions.assertNotNull(item);
    }

    @Test
    public void getAllItems(){
        List<Item> items = this.itemService.getAllItems();
        Assertions.assertNotNull(items);
    }

    @Test
    public void getItemByID(){
        Item theItem = this.itemService.getItemById(3);
        Assertions.assertEquals(3,theItem.getId());
    }

    @Test
    public void deleteByID(){
        this.itemService.deleteItem(2);
    }


}
