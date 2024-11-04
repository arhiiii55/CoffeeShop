package com.example.coffeespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeespringboot.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product , Integer> {
    Product deleteProductById(int id);
}
