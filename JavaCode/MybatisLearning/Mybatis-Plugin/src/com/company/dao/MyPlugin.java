package com.company.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 3.0
 */

/**
 * 完成插件签名：高数mybatis当前插件用来拦截哪个对象的哪个方法
 */
@Intercepts({
        @Signature(type = StatementHandler.class,method = "parameterize", args = Statement.class)
})
public class MyPlugin implements Interceptor {
    @Override
    /**
     * intercept:拦截目标对象的目标方法的执行
     */
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Plugin... intercept()");
        //动态改变sql运行参数
        Object target = invocation.getTarget();
        System.out.println(target);
        //target的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句参数: " + value);
        //修改sql语句参数
        metaObject.setValue("parameterHandler.parameterObject", 11);
        //执行目标方法
        Object proceed = invocation.proceed();
        //返回执行后的返回值
        return proceed;
    }

    @Override
    /**
     * plugin:包装目标对象：为目标对象创建一个代理对象
     */
    public Object plugin(Object target) {
        //借助Plugin的wrap方法来使用当前的Interceptor包装目标对象
        Object wrap = Plugin.wrap(target, this);
        System.out.println("Plugin... plugin()");
        //返回当前target对象创建的动态代理
        return wrap;
    }

    @Override
    /**
     * setProperties：将插件注册时的property属性设置进来
     */
    public void setProperties(Properties properties) {
        System.out.println("Plugin... setProperties()");
        System.out.println("插件配置信息: " + properties);
    }
}
