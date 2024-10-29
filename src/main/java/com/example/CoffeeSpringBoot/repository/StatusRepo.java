package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends JpaRepository<Status , Integer> {
}
