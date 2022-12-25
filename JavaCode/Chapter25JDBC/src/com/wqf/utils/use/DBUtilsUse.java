package com.wqf.utils.use;

import com.wqf.dao.domain.Actor;
import com.wqf.dao.utils.JDBCUtil_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 小白学java
 * @version 1.0
 */
public class DBUtilsUse {

    @Test
    public void testQueryMany() throws SQLException {
        //返回结果是多行的情况
        //1. 得到连接
        Connection connection = JDBCUtil_Druid.getConnection();
        //2. 使用DBUtils类和接口，引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id >= ?";
        //4. 执行相关方法，返回ArrayList结果集
        //说明:
        //(1) query方法就是执行sql语句，得到resultSet -- 封装 -- > ArrayList集合中
        //(2) connection: 连接
        //(3) sql: 执行的sql语句 ; sql语句也可以查询部分列
        //(4) new BeanListHandler<>(Actor.class):将resultSet -> Actor对象 -> 封装到ArrayList集合,
        // 底层使用反射机制获取Actor类的属性，然和进行封装
        //(5) 1 就是给sql语句中的? 赋值，可以有多个值，因为是可变参数
        //(6) 底层得到的resultSet会在query方法中进行关闭，PreparedStatement也会进行关闭
        List<Actor> list = queryRunner.query(connection,
                sql, new BeanListHandler<>(Actor.class), 1);
        /**
         *  public <T> T query(Connection conn, String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
         *         return this.query(conn, false, sql, rsh, params);
         *  }
         *  private <T> T query(Connection conn, boolean closeConn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *         if (conn == null) {
         *             throw new SQLException("Null connection");
         *         } else if (sql == null) {
         *             if (closeConn) {
         *                 this.close(conn);
         *             }
         *
         *             throw new SQLException("Null SQL statement");
         *         } else if (rsh == null) {
         *             if (closeConn) {
         *                 this.close(conn);
         *             }
         *
         *             throw new SQLException("Null ResultSetHandler");
         *         } else {
         *             PreparedStatement stmt = null;
         *             ResultSet rs = null;//得到结果集
         *             Object result = null;//接收返回的结果集
         *
         *             try {
         *                 stmt = this.prepareStatement(conn, sql);//创建PreparedStatement
         *                 this.fillStatement(stmt, params);
         *                 rs = this.wrap(stmt.executeQuery());
         *                 result = rsh.handle(rs);//返回结果集 -> arrayList(result)
         *                 [使用到了反射机制，对传入的Class对象进行分析]
         *             } catch (SQLException var33) {
         *                 this.rethrow(var33, sql, params);
         *             } finally {
         *                 try {
         *                     this.close(rs);
         *                 } finally {
         *                     this.close(stmt);
         *                     if (closeConn) {
         *                         this.close(conn);
         *                     }
         *
         *                 }
         *             }
         *
         *             return result;
         *         }
         *     }
         */
        for (Actor actor : list) {
            System.out.println(actor);
        }
        //释放资源
        JDBCUtil_Druid.close(null, null, connection);
    }
    @Test
    public void testQuerySingle() throws SQLException {
        //返回结果是单行的情况
        //1. 得到连接
        Connection connection = JDBCUtil_Druid.getConnection();
        //2. 使用DBUtils类和接口，引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id = ?";
        //说明:
        //(1) 返回单行数据 - 对象 ，使用Handler 是 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(actor);
        JDBCUtil_Druid.close(null, null, connection);
    }
    @Test
    public void testScalar() throws SQLException {
        //完成查询结果是单行单列
        //1. 得到连接
        Connection connection = JDBCUtil_Druid.getConnection();
        //2. 使用DBUtils类和接口，引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id = ?";
        Object object = queryRunner.query(connection, sql, new ScalarHandler<>(), 2);
        System.out.println(object);
        JDBCUtil_Druid.close(null, null, connection);
    }
    @Test
    public void testDML() throws SQLException {
        //完成dml语句
        //1. 得到连接
        Connection connection = JDBCUtil_Druid.getConnection();
        //2. 使用DBUtils类和接口，引入DBUtils相关的jar,加入到Project
        //3. 创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update actor set name = ? where id = ?";
        String sql1 = "insert into actor values(null, ?, ?, ?, ?)";
        String sql2 = "delete from actor where id = ?";
        //1. 执行dml操作: queryRunner.update()
        //2. 返回的值是受影响的行数
        int affectedRow = queryRunner.update(connection, sql2, 2);
        System.out.println(affectedRow > 0 ? "成功" : "失败");
        JDBCUtil_Druid.close(null, null, connection);
    }
}
