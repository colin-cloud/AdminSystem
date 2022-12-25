package com.example.bootweb01.controller;

import com.example.bootweb01.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(18);
        return person;
    }
}
