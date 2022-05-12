package dev.nexus.services;

import dev.nexus.entities.Item;
import dev.nexus.entities.Potluck;
import dev.nexus.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class ItemServicesImpl implements dev.nexus.services.ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item registerItem(Item item) {
        return this.itemRepo.save(item);
    }

    @Override
    public Item getItemById(Integer id) {
        Optional<Item> possibleItem = this.itemRepo.findById(id);
        if(possibleItem.isPresent()){
            return possibleItem.get();
        } else {
            throw new RuntimeException("No such item");
        }
    }

    @Override
    public List<Item> getAllItems() {return this.itemRepo.findAll();}

    @Override
    public boolean deleteItem(Integer id) {

        this.itemRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteItemsByPotluck(int id) {
        List<Item> items = this.itemRepo.findAll();
        items.removeIf(item -> item.getPotluckID() != id);
        this.itemRepo.deleteAllInBatch(items);
        return true;
    }

}
