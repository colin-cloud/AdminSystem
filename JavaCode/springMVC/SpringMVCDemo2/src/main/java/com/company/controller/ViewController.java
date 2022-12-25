package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class ViewController {

    @RequestMapping("/testView")
    public String testView() {
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward() {
        return "forward:/testView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testView";
    }
}
