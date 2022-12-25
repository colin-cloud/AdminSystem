package com.company.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 小白学java
 * @version 3.0
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
