package com.example.coffeespringboot.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeespringboot.entity.Product;
import com.example.coffeespringboot.service.ProductService;

@RestController
public class ProductController {
    // import product service
    // HTTPP : GET/POST/PUT
	private ProductService productService;    
    private ModelMapper modelMapper;
    
    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
		this.productService = productService;
		this.modelMapper = modelMapper;
	}
    
    @GetMapping("/products")
    public ResponseEntity<?> getAllProduct(){
    	List<Product> list =  productService.getAllProduct();
    	for (Product product : list) {
    		System.out.println("\nlist " + product);
		}
        return ResponseEntity.ok(list);
       
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable int id) {
        Product product = productService.getProductById(id);
//        System.out.println("try to print number" + product.getId());
        return ResponseEntity.ok(product);
    }
    

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        Product product = productService.deleteProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        List<Product> products = productService.createProduct(product);
        return ResponseEntity.ok(products);
        // if (product != null) {
          
        // }else{
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        // }
    }
    
}
