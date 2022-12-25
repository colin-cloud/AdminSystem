package com.company.dao;

import com.company.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    Employee getEmpAndDept(Integer id);

    void addEmployees(@Param("employees") List<Employee> employees);

    List<Employee> getEmployees();
}
