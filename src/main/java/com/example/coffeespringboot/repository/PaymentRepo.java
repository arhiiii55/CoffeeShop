package com.example.coffeespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeespringboot.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
