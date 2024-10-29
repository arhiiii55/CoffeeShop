package com.example.CoffeeSpringBoot.repository;

import com.example.CoffeeSpringBoot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role , Integer> {
}
