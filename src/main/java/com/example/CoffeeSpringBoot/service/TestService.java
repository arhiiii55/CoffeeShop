package com.example.CoffeeSpringBoot.service;

import com.example.CoffeeSpringBoot.entity.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {
    public List<Test> getListUser();
    public List<Test> createUser(Test test);
    public List<Test> deleteUser(int id);
    public List<Test> updateUser(int id,Test test);
}
