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
public class ProductInCartDTO implements Serializable {
    private int cartId;
    private int productId;
    private CartDTO cartDTO;
//    private ProductDTO productDTO;

    private int sale;

    private int quantity;
}
