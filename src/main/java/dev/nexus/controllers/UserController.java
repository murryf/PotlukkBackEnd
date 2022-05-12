package dev.nexus.controllers;


import dev.nexus.entities.*;
import dev.nexus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    public UserService userService;


    @PostMapping("/users")
    @ResponseBody
    public User createNewUser(@RequestBody User user){
        user.setUserID(0);
        return this.userService.registerUser(user);
    }



    @GetMapping("/users")
    @ResponseBody
    public List<User> retrieveAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return users;
    }


    @GetMapping("/users/{id}")
    @ResponseBody
    public User retrieveUserById(@PathVariable int id){
        User user = this.userService.getUserByID(id);
        return user;
    }


    @DeleteMapping("/users/{id}")
    @ResponseBody
    public boolean deleteUserById(@PathVariable int id){
        this.userService.deleteUser(id);
        return true;
    }




}
