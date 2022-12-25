package com.example.admin.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 小白学java
 * @version 3.0
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户数量太多")
public class UserException extends RuntimeException {

    public UserException() {}

    public UserException(String message) {
        super(message);
    }
}
