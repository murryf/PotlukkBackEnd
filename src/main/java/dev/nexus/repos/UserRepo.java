package dev.nexus.repos;

import dev.nexus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Component marks class as a Bean -> ComponentScan adds Bean to Application Context
// @Repository marks classes, which directly access Database
@Component
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
//	List<User> getUserById(int id);
    User findByUserName (String userName);

}
