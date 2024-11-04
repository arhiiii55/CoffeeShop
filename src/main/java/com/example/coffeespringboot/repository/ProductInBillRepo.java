package com.example.coffeespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeespringboot.entity.Bill;
import com.example.coffeespringboot.entity.ProductInBill;
import com.example.coffeespringboot.entity.ProductInBillKey;

import java.util.List;


@Repository
public interface ProductInBillRepo extends JpaRepository<ProductInBill, ProductInBillKey>{
    List<ProductInBill> getByBill(Bill bill);
}
