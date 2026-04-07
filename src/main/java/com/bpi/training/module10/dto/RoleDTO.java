package com.bpi.training.module10.dto;

import com.bpi.training.module10.entity.User;

public class RoleDTO {
    
    private Long id;
    private User user;
    private String role;

    public RoleDTO() {
    }

    public RoleDTO(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
