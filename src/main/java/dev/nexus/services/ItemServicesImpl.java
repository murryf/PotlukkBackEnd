package dev.nexus.Services;

import dev.nexus.entities.Item;
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

        return false;
    }
}
