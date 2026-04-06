package com.bpi.training.module10.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @InjectMocks
    private UserService userService;

    // Success
    @Test
    void createUser_success() {

        User user = new User();
        user.setUsername("sample");
        user.setPassword("samplepass");

        when(repository.existsByUsername("sample")).thenReturn(false);
        when(repository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser("sample", "samplepass");

        assertNotNull(result);
        assertEquals("sample", result.getUsername());
        verify(repository).save(any(User.class));
    }

    // Failed
    @Test
    void createUser_duplicateUsername() {
        when(repository.existsByUsername("sample")).thenReturn(true);

        assertThrows(RuntimeException.class,
                () -> userService.createUser("sample", "samplepass"));

        verify(repository, never()).save(any(User.class));
    }
}
