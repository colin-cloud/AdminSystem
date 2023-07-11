package com.example.terrissedu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Terriss
 * @time 2023-06-28 19:03:41
 * @description TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
    // 异常状态码
    private Integer code;
    // 异常信息
    private String message;
}
