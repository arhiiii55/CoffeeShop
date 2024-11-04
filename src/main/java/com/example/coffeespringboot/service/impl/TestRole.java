package com.example.coffeespringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeespringboot.entity.Cart;
import com.example.coffeespringboot.repository.CartRepo;

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
