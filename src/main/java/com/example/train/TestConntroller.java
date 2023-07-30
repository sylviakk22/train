package com.example.train;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConntroller {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello1");
        return "hello world";
    }
}
