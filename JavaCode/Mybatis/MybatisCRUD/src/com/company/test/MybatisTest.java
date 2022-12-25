package com.company.test;

import com.company.bean.Employee;
import com.company.dao.EmployeeMapper;
import com.company.dao.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 小白学java
 * @version 3.0
 */
public class MybatisTest {


    /**
     * 1. 根据xml配置文件（全局配置文件） 创建一个sqlSessionFactory对象，有数据源和一些运行环境信息
     * 2. sql映射文件：配置了每一个sql， 以及sql的封装规则等
     * 3. 将sql映射文件注册在全局配置文件中
     * 4. 步骤如下：
     * @throws IOException
     */
    @Test
    public void testMybatis() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Employee emp = sqlSession.selectOne("com.company.mybatis.EmployeeMapper.getEmpById", 1);
        System.out.println(emp);

        sqlSession.close();
    }

    @Test
    /**
     * 1. 接口式编程
     *      原生： Dao => DaoImpl
     *      mybatis： Mapper =>xxMapper.xml
     * 2. SqlSession 代表和数据库的一次会话：用完必须关闭
     * 3. SqlSession 和 connection 一样都是非线程安全的
     * 4. mapper 接口没有实现类，但是mybatis回味这个接口生成一个代理对象
     *      (将接口和xml进行绑定)
     *      EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
     * 5. 两个重要的配置文件：
     *      mybatis的全局配置文件：包括数据库连接池信息，事务管理器信息等系统运行环境  (可以没有)
     *      sql映射文件:保存了每一个sql语句的映射信息，将sql抽取出来
     */
    //不可以定义成员变量方式
    //   private SqlSession sqlSession;
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
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取接口实现类对象 - 回味接口自动地创建一个代理对象，这个代理对象来实现增删改查
        EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);

        Employee emp = mapper.getEmpById(1);
        System.out.println(emp);
    }
}
