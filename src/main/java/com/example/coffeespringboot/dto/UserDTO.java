package com.example.coffeespringboot.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO   {
	private int idUser;
    private String accountName;
    private String accountPassword;
    private String userName;
    private String email;
    private int phone;
    private String address;
    private RoleDTO roleDTO;
    private int actived;
    private LocalDateTime createDate;
    
}
