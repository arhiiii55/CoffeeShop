package com.example.CoffeeSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDTO implements Serializable {
    private int id;
    
    private String productName;

    private TypeProductDTO typeProductDTO;

    private int sale;

    private String image;

    private boolean favorite;

    private boolean actived;

    private Date createDate;

    private int price;
}
