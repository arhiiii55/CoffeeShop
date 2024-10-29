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
public class SaleCodeDTO implements Serializable {

        private int id;

        private String nameSale;

        private int sale;
}
