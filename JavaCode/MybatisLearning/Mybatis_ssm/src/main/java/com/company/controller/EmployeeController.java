package com.company.controller;

import com.company.bean.Employee;
import com.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/getEmployees")
    public String getEmployees(Map<String, Object> map) {
        List<Employee> employees = employeeService.getEmployees();
        map.put("employees", employees);
        System.out.println(employees);
        return "list";
    }
}
