package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
