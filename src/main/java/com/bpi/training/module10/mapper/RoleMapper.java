package com.bpi.training.module10.mapper;

import org.mapstruct.Mapper;

import com.bpi.training.module10.dto.RoleDTO;
import com.bpi.training.module10.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDTO roleDto);

    RoleDTO toDto(Role role);

}
