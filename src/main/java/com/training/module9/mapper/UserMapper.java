package com.training.module9.mapper;

import java.util.List;

import com.training.module9.dto.RoleDTO;
import com.training.module9.dto.UserDTO;
import com.training.module9.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {

        List<RoleDTO> roleDTOs = null;

        if (user.getRoles() != null) {
            roleDTOs = user.getRoles()
                    .stream()
                    .map(RoleMapper::toDTO)
                    .toList();
        }

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEnabled(),
                roleDTOs);
    }
}
