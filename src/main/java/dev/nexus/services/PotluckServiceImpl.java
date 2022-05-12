package dev.nexus.services;

import dev.nexus.entities.Potluck;
import dev.nexus.repos.PotluckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class PotluckServiceImpl implements PotluckService {

    @Autowired
    private PotluckRepo potluckRepo;

    @Autowired
    private ItemService itemService;



    @Override
    public Potluck createPotluck(Potluck potluck) {
        potluck.setId(0);
        return this.potluckRepo.save(potluck);
    }

    @Override
    public List<Potluck> getAllPotlucks() {
        return this.potluckRepo.findAll();
    }

    @Override
    public List<Potluck> getPotlucksByCreator(int creatorId) {
        List<Potluck> filteredPotlucks = this.potluckRepo.findPotluckByCreator(creatorId);

        return filteredPotlucks;
    }

    @Override
    public Potluck getPotluckById(int id) {
        Optional<Potluck> possiblePotluck = this.potluckRepo.findById(id);
        if(possiblePotluck.isPresent()){
            return possiblePotluck.get();
        }else{
            throw new RuntimeException("No potluck found for the id: " + id);
        }
    }

    @Override
    public Potluck updatePotluckDate(int id, String date) {
        Optional<Potluck> possiblePotluck = this.potluckRepo.findById(id);
        if (possiblePotluck.isPresent()) {
            Potluck potluck = possiblePotluck.get();
            potluck.setPotluckDate(date);
            this.potluckRepo.save(potluck);
            return potluck;
        } else {
            throw new RuntimeException("No potluck found for the id: " + id);
        }
    }

    @Override
    public boolean deletePotluckById(int id) {
      this.potluckRepo.deleteById(id);
      return true;
    }

    @Override
    public boolean deletePotluckByCreator(int id) {

        this.itemService.deleteItemsByPotluck(id);

        List<Potluck> potlucks = this.potluckRepo.findAll();
        potlucks.removeIf(potluck -> potluck.getId() != id);
        this.potluckRepo.deleteAllInBatch(potlucks);
        return true;
    }
}
