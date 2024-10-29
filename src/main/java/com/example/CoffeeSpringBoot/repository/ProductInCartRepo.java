package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.ProductInCartKey;
import com.example.CoffeeSpringBoot.entity.ProductsInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInCartRepo extends JpaRepository<ProductsInCart , ProductInCartKey> {
    
}
