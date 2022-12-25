package com.company.service.impl;

import com.company.bean.Employee;
import com.company.dao.EmployeeMapper;
import com.company.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    //进行批量操作数据的sqlSession
    private SqlSession sqlSession;

    public List<Employee> getEmployees() {
        System.out.println("查询所有员工列表~~");
        return employeeMapper.getEmployees();
    }
}
