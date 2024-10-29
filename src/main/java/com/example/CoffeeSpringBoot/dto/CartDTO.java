package com.example.CoffeeSpringBoot.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CartDTO implements Serializable {
    private int id;

    private UserDTO userDTO;
}
