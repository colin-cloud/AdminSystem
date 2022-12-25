package com.company.test;

import com.company.bean.Department;
import com.company.bean.Employee;
import com.company.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 小白学java
 * @version 3.0
 */
public class MybatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取接口实现类对象 - 回味接口自动地创建一个代理对象，这个代理对象来实现增删改查
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee emp = mapper.getEmpById(1);
        System.out.println(emp);
    }

    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpAndDept(1);
        System.out.println(employee);
    }

    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(null, "tom", "tom@qq.com", "女", new Department(1, "开发部")));
        mapper.addEmployees(emps);
        sqlSession.commit();
        sqlSession.close();
    }
}
