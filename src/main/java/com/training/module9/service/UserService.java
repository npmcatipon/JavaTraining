package com.training.module9.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.module9.dto.CreateUserDTO;
import com.training.module9.model.Role;
import com.training.module9.model.User;
import com.training.module9.repository.RoleRepository;
import com.training.module9.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserDTO userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(true);

        User savedUser = userRepository.save(user);

        // Assign Roles
        if (userDto.getRoles() != null && !userDto.getRoles().isEmpty()) {
            for (String roleName : userDto.getRoles()) {
                Role roles = new Role(savedUser, roleName);
                roleRepository.save(roles);
            }
        } else {
            Role role = new Role(savedUser, "ROLE_USER");
            roleRepository.save(role);
        }

        return savedUser;

    }

}
