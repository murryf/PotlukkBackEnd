package dev.nexus.Services;

import dev.nexus.entities.Item;

import java.util.List;

public interface ItemService {

    Item registerItem(Item item);
    Item getItemById(Integer id);
    List<Item> getAllItems();
    boolean deleteItem(Integer id);

}
