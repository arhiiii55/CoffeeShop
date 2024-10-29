package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.SaleCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleCodeRepo extends JpaRepository<SaleCode, Integer> {
}
