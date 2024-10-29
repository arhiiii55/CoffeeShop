package com.example.CoffeeSpringBoot.service.impl;

import com.example.CoffeeSpringBoot.entity.Test;
import com.example.CoffeeSpringBoot.service.TestService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestServiceImpl implements TestService {

    private static ArrayList<Test> tests = new ArrayList<>();

    @Override
    public List<Test> getListUser() {
        return tests;
    }

    @Override
    public List<Test> createUser(Test test) {
        Test lastUser = tests.get(tests.size() - 1 );
        int lastUserId = lastUser.getId() ;
        test.setId(lastUserId + 1);
        tests.add(test);
        return tests;
    }

    @Override
    public List<Test> deleteUser(int id) {
        for (Test user: tests){
            if (user.getId() == id){
                tests.remove(user);
                break;
            };
        }
        return tests;
    }

    @Override
    public List<Test> updateUser(int id, Test user) {
        for (Test userList: tests){
            if (userList.getId() == id){
                userList.setUserName(user.getUserName());
                userList.setPhone(user.getPhone());
                userList.setEmail(user.getEmail());
            };
        }
        return tests;
    }
}
