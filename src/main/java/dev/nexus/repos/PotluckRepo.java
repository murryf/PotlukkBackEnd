package dev.nexus.repos;

import dev.nexus.entities.Potluck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface PotluckRepo extends JpaRepository<Potluck, Integer> {

    List<Potluck> findPotluckByCreator(int creator);

}
