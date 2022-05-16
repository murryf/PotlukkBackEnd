package dev.nexus.controllers;


import dev.nexus.dtos.LoginInfo;
import dev.nexus.dtos.UserInfo;
import dev.nexus.entities.*;
import dev.nexus.services.LoginService;
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

    @Autowired
    LoginService loginService;


    @PostMapping("/users")
    @ResponseBody
    public User createNewUser(@RequestBody User user){
        user.setUserID(0);
        return this.userService.registerUser(user);
    }


    @PostMapping("/login")
    public UserInfo login(@RequestBody LoginInfo loginInfo){
        User user = loginService.login(loginInfo.getUserName(), loginInfo.getPassword());
        UserInfo userInfo = new UserInfo(user.getUserID(), user.getUserName());
        return userInfo;
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
