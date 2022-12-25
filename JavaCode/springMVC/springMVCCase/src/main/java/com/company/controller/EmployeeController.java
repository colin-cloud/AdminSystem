package com.company.controller;

import com.company.bean.Employee;
import com.company.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author 小白学java
 * @version 3.0
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emp";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emp";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String getAll(Model md) {
        Collection<Employee> all = employeeDao.getAll();
        System.out.println(all);
        md.addAttribute("emps", all);
        return "employees";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmpById(@PathVariable("id") Integer id, Model md) {
        Employee employee = employeeDao.get(id);
        System.out.println(employee);
        md.addAttribute("emp", employee);
        return "updateEmp";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String updateEmpById(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emp";
    }

}
