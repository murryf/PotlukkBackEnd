package dev.nexus.Potlukk;


import dev.nexus.entities.User;
import dev.nexus.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    static User testUser = null;

    @Test
    public void createUser(){
        User user = this.userService.registerUser(new User(0,"teamnexus5","gottalovebugs"));
        Assertions.assertNotNull(user);
    }

    @Test
    public void getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        Assertions.assertNotNull(users);
    }

    @Test
    public void getUserById(){
        User user = this.userService.getUserByID(1);
        Assertions.assertEquals(1,user.getUserID());
    }

    @Test
    public void deleteUser(){
        this.userService.deleteUser(1);
    }
}
