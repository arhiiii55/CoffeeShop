package com.example.coffeespringboot.service;

import org.springframework.stereotype.Service;

import com.example.coffeespringboot.entity.Product;

import java.util.List;

@Service
public interface ProductService {
    // Get all information
    List<Product> getAllProduct();

    Product getProductById(int id);

    // update 
    Product updateProductById(int id, Product product);

    // delete
    Product deleteProductById(int id);

    // create
    List<Product> createProduct(Product product);

}
