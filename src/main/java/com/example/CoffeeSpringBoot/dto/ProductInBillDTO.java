package com.example.CoffeeSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductInBillDTO implements Serializable {
    private int billId;
    private int productId;

    private int sale;
    private int quantity;
}
