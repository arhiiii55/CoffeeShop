package com.example.coffeespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeespringboot.entity.ProductInCartKey;
import com.example.coffeespringboot.entity.ProductsInCart;

@Repository
public interface ProductInCartRepo extends JpaRepository<ProductsInCart , ProductInCartKey> {
    
}
