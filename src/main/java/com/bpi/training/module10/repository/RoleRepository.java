package com.bpi.training.module10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpi.training.module10.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
