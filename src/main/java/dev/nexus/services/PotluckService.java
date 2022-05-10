package dev.nexus.Services;

import dev.nexus.entities.Potluck;

import java.util.List;

public interface PotluckService {

    Potluck createPotluck(Potluck potluck);
    List<Potluck> getAllPotlucks();
    Potluck getPotluckById(int id);
    Potluck updatePotluckTime(int id);
    Potluck deletePotluckById(int id);

}
