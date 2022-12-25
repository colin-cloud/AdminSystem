package com.wqf.chinesebuid.service;

import com.wqf.chinesebuid.dao.EmployeeDAO;
import com.wqf.chinesebuid.domain.Employee;

/**
 * @author 小白学java
 * @version 1.0
 */
public class EmployeeService {
    //进行相关的业务处理
    //通过EmployeeDAO进行相关数据库操作
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    //编写一个方法进行登录身份的验证
    public Employee getEmployee(String empId, String password) {
        String sql = "select * from employee where empId = ? and password = md5(?)";
        Employee employee = employeeDAO.querySingle(sql, Employee.class, empId, password);
        return employee;
    }
}
