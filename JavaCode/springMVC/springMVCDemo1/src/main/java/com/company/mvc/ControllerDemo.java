package com.company.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class ControllerDemo {

    //访问index.xml
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/param")
    public String param() {
        return "param";
    }
}
