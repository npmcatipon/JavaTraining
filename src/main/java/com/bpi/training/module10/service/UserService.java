package com.bpi.training.module10.service;

import org.springframework.stereotype.Service;

import com.bpi.training.module10.entity.User;
import com.bpi.training.module10.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(String username, String password) {
        if (repository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists.");
        }

        User newUser = new User(username, password);

        return repository.save(newUser);
    }

    public User addRole(String username, String role) {
        User user = repository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("Username is not existing");
        }
        user.setRoles(role);
        return repository.save(user);
    }
}
