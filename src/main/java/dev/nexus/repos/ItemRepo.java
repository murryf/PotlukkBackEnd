package dev.nexus.repos;

import dev.nexus.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepo extends JpaRepository<Item, Integer> {
}
