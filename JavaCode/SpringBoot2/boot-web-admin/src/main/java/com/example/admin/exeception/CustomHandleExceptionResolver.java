package com.example.admin.exeception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 3.0
 */
@Component
/**
 * 自定义异常解析器
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE) // 定义优先级，数字越小，优先级越高
public class CustomHandleExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.sendError(511, "自己定制的异常状态码~~~");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
