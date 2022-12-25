package com.company.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 3.0
 */
@Intercepts({
        @Signature(type = StatementHandler.class,method = "parameterize", args = Statement.class)
})
public class MySecondPlugin implements Interceptor {
    @Override
    /**
     * intercept:拦截目标对象的目标方法的执行
     */
    public Object intercept(Invocation invocation) throws Throwable {
        //执行目标方法
        Object proceed = invocation.proceed();
        System.out.println("Plugin2... intercept()");
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
        System.out.println("Plugin2... plugin()");
        //返回当前target对象创建的动态代理
        return wrap;
    }

    @Override
    /**
     * setProperties：将插件注册时的property属性设置进来
     */
    public void setProperties(Properties properties) {
        System.out.println("Plugin2... setProperties()");
        System.out.println("插件配置信息: " + properties);
    }
}
