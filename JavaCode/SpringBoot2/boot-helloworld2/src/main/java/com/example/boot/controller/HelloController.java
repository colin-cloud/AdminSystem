package com.example.boot.controller;

import com.example.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小白学java
 * @version 3.0
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person() {
        return person;
    }
}
