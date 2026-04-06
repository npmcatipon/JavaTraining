package com.bpi.training.module10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpi.training.module10.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
}
