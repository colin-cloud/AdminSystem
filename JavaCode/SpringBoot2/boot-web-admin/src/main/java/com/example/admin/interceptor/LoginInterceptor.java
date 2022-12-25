package com.example.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 小白学java
 * @version 3.0
 */

/**
 * 1. 配置好拦截器要拦截哪些请求
 * 2. 把这些配置放在容器中
 */
@Controller
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录检查
        HttpSession session = request.getSession();
        Object user = session.getAttribute("loginUser");
        if (user != null) {
            return true;
        }
//        response.sendRedirect("/");
//        session.setAttribute("msg", "请先登录");
        //使用request进行转发
        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

