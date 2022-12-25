package com.company.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
@RequestMapping("hello")
public class RequestMappingController{

    //访问index.xml
    //需要保证请求地址唯一
    //这里会报错
    /*
    @RequestMapping(value = "/")
    public String index() {
        return "target";
    }
     */
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username"}
    )
    public String success() {
        return "success";
    }
    //RequestMapping派生注解
    @GetMapping(value = "/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(value = "/testPut",params = {"username"})
    public String testPut() {
        return "success";
    }

    @RequestMapping(
            value = {"/testParameters", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username"}
    )
    public String testParameters() {
        return "success";
    }

    @RequestMapping(value = "/testA?t")
    public String testAnt() {
        return "success";
    }

    @RequestMapping(value = "/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        return "success";
    }
}
