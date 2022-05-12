package dev.nexus.services;


import dev.nexus.entities.User;
import dev.nexus.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerUser(User user) {
        user.setUserID(0);
        return this.userRepo.save(user);
    }


    @Override
    public User getUserByID(int id) {
        Optional<User> possibleUser = this.userRepo.findById(id);
        if(possibleUser.isPresent()){
            return possibleUser.get();
        } else {
            throw new RuntimeException("No such user");
        }
    }



    @Override
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }


    @Override
    public boolean deleteUser(int id) {
        this.userRepo.deleteById(id);
        return true;
    }
}