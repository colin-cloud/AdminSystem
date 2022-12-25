package com.company2;

import com.company2.dao.UserDao;
import com.company2.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author 小白学java
 * @version 3.0
 */
public class JDKProxy {

    public static void main(String[] args) {

        //创建实现接口类代理对象
        Class[] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        })
        UserDaoImpl userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        UserDao proxyInstance = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, userDaoProxy);
//        int res = proxyInstance.add(1, 2);
        String res = proxyInstance.update("hello");
        System.out.println(res);
    }
}

//创建代理对象
class UserDaoProxy implements InvocationHandler {

    private Object obj;
    //把创建对象的代理对象引入
    //有参构造引入
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }


    //https://www.csdn.net/tags/MtjakgwsOTIwMDQtYmxvZwO0O0OO0O0O.html
    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行" + method.getName() + "传递的参数:" + Arrays.toString(args));
        //需要增强逻辑的方法执行
        Object res = method.invoke(obj, args);
        //方法之后
        System.out.println("方法之后执行...");
        return res;
    }
}
