package com.company.service;

import com.company.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@Service
public interface EmployeeService {

    List<Employee> getEmployees();
}
