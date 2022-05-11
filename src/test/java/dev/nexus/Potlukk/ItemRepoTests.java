package dev.nexus.Potlukk;


import dev.nexus.entities.Item;
import dev.nexus.repos.ItemRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemRepoTests {

    static Item testItem = null;

    @Autowired
    private ItemRepo itemRepo;


}
