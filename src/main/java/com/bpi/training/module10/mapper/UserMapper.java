package com.bpi.training.module10.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bpi.training.module10.dto.UserDTO;
import com.bpi.training.module10.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "roles", ignore = true)
    User toEntity(UserDTO userDto);

    @Mapping(target = "role", ignore = true)
    UserDTO toDto(User user);
    
} 