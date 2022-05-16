package dev.nexus.services;

import dev.nexus.entities.User;
import dev.nexus.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User login(String userName, String password) {
        User user = userRepo.findByUserName(userName);
        if(user == null){
            throw new RuntimeException("No user with that username");

        }
        if(user.getPassword().equals(password)){
            return user;
        }else{
            throw new RuntimeException("password does not match");
        }

    }
}
