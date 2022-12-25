package com.example.bootweb01.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{userName}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("userName") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam("params") Map<String, String> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("header", header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        return map;
    }

    @PostMapping("/save")
    public Map getMap(@RequestBody String content) {
        Map map = new HashMap();
        map.put("content", content);
        return map;
    }
}
