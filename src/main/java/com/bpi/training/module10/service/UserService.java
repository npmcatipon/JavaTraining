package com.bpi.training.module10.service;

import javax.management.RuntimeErrorException;

import com.bpi.training.module10.dto.UserDTO;
import com.bpi.training.module10.entity.User;
import com.bpi.training.module10.exception.UsernameAlreadyExistException;
import com.bpi.training.module10.mapper.UserMapper;
import com.bpi.training.module10.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper
    ){ 
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO userDto) {
        if(userRepository.existsByUsername(userDto.getUsername())) {
            throw new UsernameAlreadyExistException();
        }

        User user = userRepository.findByUsername(userDto.getUsername())

        return userMapper.toDto(user);
            
    }

}
