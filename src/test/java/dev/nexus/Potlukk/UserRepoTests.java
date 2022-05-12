package dev.nexus.Potlukk;


import dev.nexus.entities.User;
import dev.nexus.repos.UserRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepoTests {

    static User testUser = null;

    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    public void createUser(){
        User user = new User(0, "its_paul", "golakers");
        userRepo.save(user);
        testUser = user;
        System.out.println(user);
        Assertions.assertNotEquals(0, user.getUserID());
    }

    @Test
    @Order(2)
    public void getUserById(){
        Optional<User> possibleUser = this.userRepo.findById(1);
        if(possibleUser.isPresent()){
            User localUser = possibleUser.get();
            System.out.println(localUser);
            Assertions.assertEquals(1,localUser.getUserID());
        }
    }

    @Test
    @Order(3)
    public void getAllUsers(){
        List<User> users = this.userRepo.findAll();
        Assertions.assertNotNull(users);
    }

    @Test
    @Order(4)
    public void deleteUser(){
        this.userRepo.deleteById(1);
    }



}
