package com.bpi.training.module10.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bpi.training.module10.entity.User;
import com.bpi.training.module10.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;

    private User user;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void startup() {
        user = new User();
        user.setUsername("sample");
        user.setPassword("samplepass");
    }

    // Successful user creation
    @Test
    void createUser_success() {

        when(repository.existsByUsername("sample")).thenReturn(false);
        when(repository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser("sample", "samplepass");

        assertNotNull(result);
        assertEquals("sample", result.getUsername());
        verify(repository).save(any(User.class));
    }

    // Failed user creation
    @Test
    void createUser_duplicateUsername() {
        when(repository.existsByUsername("sample")).thenReturn(true);

        assertThrows(RuntimeException.class,
                () -> userService.createUser("sample", "samplepass"));

        verify(repository, never()).save(any(User.class));
    }

    // Successful adding roles
    @Test
    void addRole_success() {
        when(repository.findByUsername("sample")).thenReturn(user);
        when(repository.save(any(User.class))).thenReturn(user);

        User result = userService.addRole("sample", "USER");

        assertNotNull(result);
        assertEquals("USER", result.getRoles());

        verify(repository).save(any(User.class));
    }

    @Test
    void addRole_usernameNotExisting() {
        when(repository.findByUsername("sample2")).thenReturn(null);

        RuntimeException e = assertThrows(RuntimeException.class,
                () -> userService.addRole("sample2", "USER"));

        assertEquals("Username is not existing", e.getMessage());
    }
}
