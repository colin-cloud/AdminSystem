package com.example.admin.controller;

import com.example.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class TableController {

    @GetMapping("/basicTable")
    public String basicTable() {
        return "table/basic_table";
    }

    @GetMapping("/dynamicTable")
    public String dynamicTable(Model model) {
        List<User> users = Arrays.asList(
                new User("张三", "123456"),
                new User("李四", "34u2djfa")
        );
        model.addAttribute("users", users);
        return "table/dynamic_table";
    }

    @GetMapping("/responseTable")
    public String responseTable() {
        return "table/response_table";
    }

    @GetMapping("/editTable")
    public String editTable() {
        return "table/edit_table";
    }
}
