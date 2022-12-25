package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class TestController {

//    @RequestMapping(value = "/")
//    public String index() {
//        return "index";
//    }

//    @RequestMapping("/view")
//    public String view() {
//        return "view";
//    }

    @RequestMapping("/rest")
    public String rest() {
        return "rest";
    }
}
