package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class JSPController {

    @RequestMapping("/testJsp")
    public String testJsp() {
        return "success";
    }
}
