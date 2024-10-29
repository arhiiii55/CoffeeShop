package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.ProductInBill;
import com.example.CoffeeSpringBoot.entity.ProductInBillKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.CoffeeSpringBoot.entity.Bill;


@Repository
public interface ProductInBillRepo extends JpaRepository<ProductInBill, ProductInBillKey>{
    List<ProductInBill> getByBill(Bill bill);
}
