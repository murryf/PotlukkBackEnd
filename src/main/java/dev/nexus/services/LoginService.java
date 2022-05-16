package dev.nexus.services;

import dev.nexus.entities.User;

public interface LoginService {

    User login(String userName, String password);
}
