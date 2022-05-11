package dev.nexus.services;

import dev.nexus.Repos.PotluckRepo;
import dev.nexus.entities.Potluck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class PotluckServiceImpl implements dev.nexus.Services.PotluckService {

    @Autowired
    private PotluckRepo potluckRepo;



    @Override
    public Potluck createPotluck(Potluck potluck) {
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
    public Potluck updatePotluckTime(int id, double date) {
        Potluck potluck = this.potluckRepo.getById(id);
        potluck.setPotluckDate(date);
        this.potluckRepo.save(potluck);
        return potluck;
    }

    @Override
    public boolean deletePotluckById(int id) {
      this.potluckRepo.deleteById(id);
      return true;
    }
}
