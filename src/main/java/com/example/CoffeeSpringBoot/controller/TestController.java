package com.example.CoffeeSpringBoot.controller;

import com.example.CoffeeSpringBoot.entity.Cart;
import com.example.CoffeeSpringBoot.entity.Test;
import com.example.CoffeeSpringBoot.service.TestService;
import com.example.CoffeeSpringBoot.service.impl.TestRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    public  TestService testService ;

    @Autowired
    public TestRole testRole ;

    @GetMapping("/userView")
    public ResponseEntity<?> getListUser() {
        List<Test> tests = testService.getListUser();
        return ResponseEntity.ok(tests);
    }

    @PostMapping("/userView")
    public ResponseEntity<?> createUser(@RequestBody Test user) {
        List<Test> users = testService.createUser(user);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/userView/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        System.out.println(id);
        List<Test> users = testService.deleteUser(id);
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("userDel/{id}")
    public ResponseEntity<?> deleteUserQuery(@PathVariable int id) {
        System.out.println(id);
        List<Test> users = testService.deleteUser(id);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/userView/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody Test test) {
        List<Test> users = testService.updateUser(id,test);
        return ResponseEntity.ok(users);
    }

    //---- test
        @GetMapping("/testcarts")
    public ResponseEntity<?> getcart(){
        List<Cart> carts = testRole.getCart();
        return ResponseEntity.ok(carts);
    }
}
