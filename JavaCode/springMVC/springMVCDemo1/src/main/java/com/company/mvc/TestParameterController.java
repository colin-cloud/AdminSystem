package com.company.mvc;

import com.company.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class TestParameterController {

    @RequestMapping(value = "/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        //request表示请求
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username + "password = " + password);
        return "success";
    }

    @RequestMapping(value = "/testParam")
    public String testParam(
            @RequestParam("username") String username,
            String password,
            String hobby,
            @RequestHeader("Host") String host, @CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("username : " + username + " " + "id : " + password + " " + "hobby : " + hobby);
        System.out.println("Host : " + host);
        System.out.println("JSESSIONID : " + JSESSIONID);
        return "success";
    }

    @RequestMapping(value = "/testPojoParam")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
