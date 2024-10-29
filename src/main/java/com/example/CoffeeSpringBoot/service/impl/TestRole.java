package com.example.CoffeeSpringBoot.service.impl;

import com.example.CoffeeSpringBoot.entity.Cart;
import com.example.CoffeeSpringBoot.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestRole {
    @Autowired
    private CartRepo cartRepo;

    public List<Cart> getCart(){
        // System.out.println(ProductServiceImpl.count);
        return cartRepo.findAll();
    }
}
