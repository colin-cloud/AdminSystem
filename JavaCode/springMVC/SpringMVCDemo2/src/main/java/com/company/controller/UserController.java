package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class UserController {

    //使用restful风格来模拟用户资源的增删改查
    /*
       /user  GET 查询所有的用户信息
       /user/1 GET 查询指定的用户的信息
       /user   POST 添加用户信息
       /user/1 DELETE 删除指定用户
       /user/1 PUT 更新用户信息
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/1", method = RequestMethod.GET)
    public String getUserById() {
        System.out.println("查询指定用户信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(String username, String password) {
        System.out.println("添加用户信息" + username + password);
        return "success";
    }

    @RequestMapping(value = "/user/1", method = RequestMethod.DELETE)
    public String deleteUserById(){
        System.out.println("删除指定用户信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password) {
        System.out.println("更新用户信息" + username + password);
        return "success";
    }
}
