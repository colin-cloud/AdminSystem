package com.example.boot.controller;

import com.example.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小白学java
 * @version 3.0
 */
@RestController
public class HelloController {

    @Value("${person.name:李四}")
    private String name;
    @Autowired
    private Person person;

    @GetMapping("/")
    public String index() {
        return "Hello" + name;
    }

    @GetMapping("/testObj")
    public Person person() {
        return person;
    }
}
