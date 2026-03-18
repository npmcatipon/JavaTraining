package com.training.module9.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String username;
    private Boolean enabled;
    private List<RoleDTO> roles;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, Boolean enabled, List<RoleDTO> roles) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
        this.roles = roles;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
