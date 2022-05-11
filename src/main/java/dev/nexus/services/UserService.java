package dev.nexus.services;

import dev.nexus.entities.User;

import java.util.List;

public interface UserService {

    User registerUser (User user);

    User getUserByID (int id);

    List<User> getAllUsers();

    boolean deleteUser (int id);



}
