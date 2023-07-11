package com.example.terrissedu.handle;

import com.example.terrissedu.exception.CustomException;
import com.example.terrissedu.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Terriss
 * @time 2023-06-28 16:27:01
 * @description 统一异常处理类
 */

@ControllerAdvice
@Slf4j // 用于将异常信息写入到文件中
public class GlobalExceptionHandle {

    // 指定出现什么异常执行该方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 返回json数据
    public CommonResult<Exception> error(Exception e) {
        CommonResult<Exception> res = new CommonResult<>();
        res.error(e.getMessage());
        res.setData(e);
        return res;
    }

    // 特定的异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 返回json数据
    public CommonResult<ArithmeticException> error(ArithmeticException e) {
        CommonResult<ArithmeticException> res = new CommonResult<>();
        res.error(e.getMessage());
        res.setData(e);
        return res;
    }

    // 自定义异常处理
    @ExceptionHandler(CustomException.class)
    @ResponseBody // 返回json数据
    public CommonResult<CustomException> error(CustomException e) {
        CommonResult<CustomException> res = new CommonResult<>();
        res.error(e.getMessage());
        res.setData(e);
        // 将信息写入到文件中
        log.error(e.getMessage());
        return res;
    }
}
