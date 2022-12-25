package com.company2.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 小白学java
 * @version 3.0
 */
//增强的类
@Component(value = "userProxy")
@Aspect     //生成代理对象
@Order(3) //值越小，优先级越高
public class UserProxy {

    //相同切入点进行抽取
    @Pointcut(value = "execution(* com.company2.aopanno.User.add(..))")
    public void pointDemo() {

    }

    //前置通知
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("before()...");
    }

    //后置通知
    @After(value = "pointDemo()")
    public void after() {
        System.out.println("after()...");
    }

    //返回通知
    @AfterReturning(value = "pointDemo()")
    public void returning() {
        System.out.println("returning()...");
    }

    //环绕通知
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前...");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...");
    }

    //异常通知
    @AfterThrowing(value = "pointDemo()")
    public void throwing() {
        System.out.println("throwing()...");
    }

}
