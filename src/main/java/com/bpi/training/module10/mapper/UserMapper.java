package com.bpi.training.module10.mapper;

import org.mapstruct.Mapper;

import com.bpi.training.module10.dto.UserDTO;
import com.bpi.training.module10.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDto);

    UserDTO toDto(User user);
    
} 