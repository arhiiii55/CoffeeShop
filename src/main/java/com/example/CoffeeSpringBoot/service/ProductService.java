package com.example.CoffeeSpringBoot.service;

import com.example.CoffeeSpringBoot.entity.Product;
import org.springframework.stereotype.Service;

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
