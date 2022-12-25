package com.example.boot.service;

import com.example.boot.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 小白学java
 * @version 3.0
 */
public class HelloService {


    @Autowired
    private HelloProperties helloProperties;

    public String sayHello(String userName) {
        return helloProperties.getPrefix() + ": " + userName + ">>" + helloProperties.getSuffix();
    }
}
