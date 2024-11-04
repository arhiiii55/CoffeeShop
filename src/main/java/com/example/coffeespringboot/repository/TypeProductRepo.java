package com.example.coffeespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeespringboot.entity.TypeProduct;

@Repository
public interface TypeProductRepo extends JpaRepository<TypeProduct , Integer> {
}