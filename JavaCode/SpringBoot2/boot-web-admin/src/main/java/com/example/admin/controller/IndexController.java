package com.example.admin.controller;

import com.example.admin.bean.Bank;
import com.example.admin.bean.City;
import com.example.admin.bean.User;
import com.example.admin.service.BankService;
import com.example.admin.service.CityService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
//@MapperScan("com.example.admin.*")
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BankService bankService;

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/insertCity")
    public City saveCity(City city) {
        cityService.insert(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/getCityById")
    public City getCityById(@RequestParam("id") Integer id) {
        return cityService.getCityById(id);
    }

    @ResponseBody
    @GetMapping("/getBank")
    public Bank getById(@RequestParam("id") Integer id) {
        return bankService.getBankById(id);
    }

    @ResponseBody
    @GetMapping("/query")
    public String query() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_bank", Long.class);
        return aLong.toString();
    }

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @PostMapping("/index")
    public String index(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.username) && StringUtils.hasLength(user.password)) {
            session.setAttribute("loginUser", user);
            //登录成功,重定向到index页面 ：防止表单重复提交
            return "redirect:/index.html";
        } else {
            //登录失败，返回登录页面
            //设置提示信息
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    @GetMapping("/index.html")
    public String indexPage(HttpSession session, Model model) {
        return "index";
    }
}
