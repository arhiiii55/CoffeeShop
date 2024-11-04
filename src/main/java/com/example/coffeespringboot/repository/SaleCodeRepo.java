package com.example.coffeespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeespringboot.entity.SaleCode;

@Repository
public interface SaleCodeRepo extends JpaRepository<SaleCode, Integer> {
}
