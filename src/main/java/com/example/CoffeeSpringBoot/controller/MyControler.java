package com.example.CoffeeSpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControler {
    @RequestMapping(value={"/hello-first"})
    public String hello() {
        return "The first test";
    }

}
