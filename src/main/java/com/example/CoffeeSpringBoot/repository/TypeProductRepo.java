package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProductRepo extends JpaRepository<TypeProduct , Integer> {
}
