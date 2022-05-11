package dev.nexus.services;

import dev.nexus.entities.Potluck;

import java.util.List;

public interface PotluckService {

    Potluck createPotluck(Potluck potluck);

    List<Potluck> getAllPotlucks();
    List<Potluck> getPotlucksByCreator(int creatorId);
    Potluck getPotluckById(int id);

    Potluck updatePotluckDate(int id, double date);
    boolean deletePotluckById(int id);

}
