package com.wqf.data_;

import java.util.Scanner;
import java.lang.String;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework01 {

    public static void main(String[] args) {

        Information information = new Information();
        try {
            information.registerInfo();
            System.out.println("注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Information {
    private String userName;
    private String keyword;
    private String email;
    Scanner scanner = new Scanner(System.in);

    public void registerInfo() {
        //输入用户名
        userName = scanner.next();
        if (!(userName.length() >= 2 && userName.length() <= 4)) {
            throw new RuntimeException("输入姓名长度错误");
        }
        keyword = scanner.next();
        try {
            int key = Integer.parseInt(keyword);
        } catch (NumberFormatException e) {
            throw new RuntimeException("输入密码错误");
        }
        if (keyword.length() != 6) {
            throw new RuntimeException("输入密码长度必须为6");
        }
        email = scanner.next();
        //先找@ .
        if (!(email.indexOf(email, '@') != -1 && email.indexOf(email, '.') != -1
                && email.lastIndexOf(email, '@') < email.lastIndexOf(email, '.')
                && email.indexOf(email, '@') != email.lastIndexOf(email, '@')
                && email.indexOf(email, '.') != email.lastIndexOf(email, '.'))) {
            throw new RuntimeException("输入邮箱错误");
        }
    }
}
