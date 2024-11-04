package com.example.coffeespringboot.dto;

public class RoleDTO {
	private int idRole;
    private String roleNameDTO;
    
    public RoleDTO() {
    }
	
	public RoleDTO(int idRole, String roleNameDTO) {
		super();
		this.idRole = idRole;
		this.roleNameDTO = roleNameDTO;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRoleNameDTO() {
		return roleNameDTO;
	}
	public void setRoleNameDTO(String roleNameDTO) {
		this.roleNameDTO = roleNameDTO;
	}    
    
}
