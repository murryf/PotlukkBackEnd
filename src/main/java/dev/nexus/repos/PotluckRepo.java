package dev.nexus.Repos;

import dev.nexus.entities.Potluck;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PotluckRepo extends JpaRepository<Potluck, Integer> {

    List<Potluck> findPotluckByCreator(String creator);
}
