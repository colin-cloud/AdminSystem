package com.company2.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 小白学java
 * @version 3.0
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.company2.aopanno.User.add(..))")
    public void before() {
        System.out.println("person before()...");
    }
}
