package com.training.module9.mapper;

import com.training.module9.dto.RoleDTO;
import com.training.module9.model.Role;

public class RoleMapper {

    public static RoleDTO toDTO(Role role) {
        if (role == null)
            return null;

        return new RoleDTO(role.getId(), role.getRole());
    }
}
