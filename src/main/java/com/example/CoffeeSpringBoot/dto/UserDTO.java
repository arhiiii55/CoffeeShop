package com.example.CoffeeSpringBoot.dto;

import java.time.LocalDateTime;

import lombok.ToString;


@ToString
public class UserDTO   {
    private String accountName;
    private String accountPassword;
    private String userName;
    private String email;
    private int phone;
    private String address;
    private RoleDTO roleDTO;
    private int actived;
    private LocalDateTime createDate;
    
	public UserDTO(String accountName, String accountPassword, String userName, String email, int phone,
			String address, RoleDTO roleDTO, int actived, LocalDateTime createDate) {
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.roleDTO = roleDTO;
		this.actived = actived;
		this.createDate = createDate;
	}
	public UserDTO() {};
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}
	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
	public int getActived() {
		return actived;
	}
	public void setActived(int actived) {
		this.actived = actived;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
    
}
