package com.training.module9.dto;

public class RoleDTO {

    private Long id;
    private String roleName;

    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

}
