package dev.nexus.services;

import dev.nexus.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ItemServicesImpl implements ItemService{


    @Override
    public Item registerItem(Item item) {
        return null;
    }

    @Override
    public Item getItemById(Integer id) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public boolean deleteItem(Integer id) {
        return false;
    }
}
