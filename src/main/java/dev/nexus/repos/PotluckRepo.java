package dev.nexus.Repos;

import dev.nexus.entities.Potluck;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface PotluckRepo {

    List<Potluck> getPotluckByCreator(String creator);

}
