package com.wqf.reflection.introduce;

import com.wqf.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.get("classFullPath").toString();
        String method = properties.get("method").toString();
        //1. 加载类,返回class类型的对象
        Class aClass = Class.forName(classFullPath);
        //2. 通过class对象得到加载的类的对象实例
        Object o = aClass.newInstance();
        //3. 通过class对象得到方法对象
        //在反射中，可以把方法视为对象
        Method method1 = aClass.getMethod(method);
        //4. 通过Method对象调用方法
        method1.invoke(o);
        //5. 得到对象中的成员变量
        //getField方法不能得到私有属性
        Field name = aClass.getField("name");
        System.out.println(name.get(o));
        //6. 得到构造方法,可以传入参数类型
        Constructor constructor = aClass.getConstructor();
        System.out.println(constructor);
        //传入的String.class是String的class对象
        Constructor constructor1 = aClass.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
