package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */

@Controller
public class ScopeController {

    @RequestMapping("/testScopeParam")
    public String testScopeParam(HttpServletRequest request) {
        request.setAttribute("testScope", "value");
        //请求转发
        return "success";
    }

    //important
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        //处理模型数据
        modelAndView.addObject("testScope", "value");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/testModel")
    public String testModel(Model model) {
        model.addAttribute("testScope", "model");
        return "success";
    }

    @RequestMapping(value = "/testMapping")
    public String testMapping(Map<String, Object> map) {
        map.put("testScope", "map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testScope", "hello,modelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession httpSession) {
        httpSession.setAttribute("testSession", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplication", "hello, application");
        return "success";
    }
}
