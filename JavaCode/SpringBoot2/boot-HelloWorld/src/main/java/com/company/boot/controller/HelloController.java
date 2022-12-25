package com.company.boot.controller;

import com.company.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小白学java
 * @version 3.0
 */

//@RequestBody
//@Controller

@Slf4j // 记录日志
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01() {
        log.info("请求进来了");
        return "Hello, SpringBoot2 !" + "你好";
    }

    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car() {
        return car;
    }
}
