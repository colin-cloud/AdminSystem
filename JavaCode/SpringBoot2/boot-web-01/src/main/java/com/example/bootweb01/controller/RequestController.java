package com.example.bootweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String page(HttpServletRequest request) {
        request.setAttribute("msg", "成功了");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public String success(HttpServletRequest request,
                          @RequestAttribute("msg") String msg) {
        System.out.println(request.getAttribute("msg"));
        System.out.println(msg);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/cars/{path}")
    // /cars/sells;low=34;brand=byd,audi,yd
    //Springboot默认禁用矩阵变量
    //矩阵变量和路径进行绑定
    public Map carSell(@MatrixVariable("low") Integer low,
                       @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path) {
        Map map = new HashMap();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @ResponseBody
    @RequestMapping("/boss/{bossId}/{empId}")
    // /boss/1;age=20/2;age=20
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map map = new HashMap();
        map.put("bossId", bossAge);
        map.put("empId", empAge);
        return map;
    }

    @GetMapping("/param")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        map.put("hello", "world");
        model.addAttribute("world", "hello");
        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);
        return "forward:/success";
    }

}
