package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product , Integer> {
    Product deleteProductById(int id);
}
