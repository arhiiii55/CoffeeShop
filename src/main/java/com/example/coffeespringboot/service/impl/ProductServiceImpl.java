package com.example.coffeespringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;

import com.example.coffeespringboot.entity.Product;
import com.example.coffeespringboot.repository.ProductRepo;
import com.example.coffeespringboot.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // private static int count =  10 ;
	
    @Autowired
    private ProductRepo productRepo ;

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    public Product updateProductById(int id, Product product) {
        return null;
    }

    @Override
    public Product deleteProductById(int id) {
        Product productById = productRepo.findById(id).get();
        // if (productById != null) {
        //     Product product = productRepo.deleteProductById(id);
        //     return product;
        // }
        return productById;
    }

    @Override
    public List<Product> createProduct(Product product) {
        productRepo.save(product);
        return productRepo.findAll();
        // if (!list.contains(product)) {
           
        // }else {
        //     System.out.println("it's okey");
        // }
        // return list;
    }

}
