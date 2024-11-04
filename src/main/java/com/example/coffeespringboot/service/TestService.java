package com.example.coffeespringboot.service;

import org.springframework.stereotype.Service;

import com.example.coffeespringboot.entity.Test;

import java.util.List;

@Service
public interface TestService {
    public List<Test> getListUser();
    public List<Test> createUser(Test test);
    public List<Test> deleteUser(int id);
    public List<Test> updateUser(int id,Test test);
}
