package com.example.admin.exeception;

/**
 * @author 小白学java
 * @version 3.0
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class}) //处理异常
    public String handleArithmeticException(Exception e) {
        log.error("异常是：{}", e);
        //返回视图地址
        return "login";
    }
}
