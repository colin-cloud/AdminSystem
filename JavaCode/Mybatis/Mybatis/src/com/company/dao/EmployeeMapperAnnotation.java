package com.company.dao;

import com.company.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author 小白学java
 * @version 3.0
 */
public interface EmployeeMapperAnnotation {

    @Select(value = "select * from t_emp where id = #{id}")
    Employee getEmpById(Integer id);
}
