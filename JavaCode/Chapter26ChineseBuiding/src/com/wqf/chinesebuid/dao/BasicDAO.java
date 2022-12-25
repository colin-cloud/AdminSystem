package com.wqf.chinesebuid.dao;

import com.wqf.chinesebuid.utils.JDBCUtil_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 小白学java
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class BasicDAO<T> {//泛型指定具体类型
    //开发BasicDAO,是其他DAO的父类
    private QueryRunner queryRunner = new QueryRunner();

    //开发通用的dml方法，任意的表
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtil_Druid.getConnection();
            //得到受影响的行数
            int update = queryRunner.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtil_Druid.close(null, null, connection);
        }
    }
    //返回多个对象(查询结果是多行),针对任意表
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtil_Druid.getConnection();
            //得到数据集合
            List<T> list = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtil_Druid.close(null, null, connection);
        }
    }
    //返回单个对象(查询结果是单行)
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtil_Druid.getConnection();
            //得到单行数据
            T t = queryRunner.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtil_Druid.close(null, null, connection);
        }
    }
    //返回单个值
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtil_Druid.getConnection();
            //得到单个数据
            Object o = queryRunner.query(connection, sql, new ScalarHandler<>(), parameters);
            return o;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtil_Druid.close(null, null, connection);
        }
    }
}
