package com.company.controller;

import com.company.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
//        当前requestEntity表示整个请求报文的信息
        System.out.println("requestHeader:" + requestEntity.getHeaders());
        System.out.println("requestBody:" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public String testResponse(HttpServletResponse resp) throws IOException {
        resp.getWriter().print("你好");
        //相应数据不需要进行页面跳转
        return null;
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        //返回响应体数据
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User("admin", "123");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println("username:" + username + "password:" + password);
        return "hello, Axios";
    }
}
