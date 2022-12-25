package com.company2.aopanno;

import org.springframework.stereotype.Component;

/**
 * @author 小白学java
 * @version 3.0
 */
//被增强的类
@Component(value = "user")
public class User {

    public void add() {
        System.out.println("add()...");
    }
}
