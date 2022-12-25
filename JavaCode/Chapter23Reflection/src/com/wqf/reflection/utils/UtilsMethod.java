package com.wqf.reflection.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 小白学java
 * @version 1.0
 */
public class UtilsMethod {

    public static void main(String[] args) {


    }
    @Test
    public void api2() throws Exception {
        Class<?> aClass = Class.forName("com.wqf.reflection.utils.Person");
//        Method[] declaredMethods = aClass.getDeclaredMethods();
//        for (Method method : declaredMethods) {
//            System.out.println(method.getName());
//            System.out.println(method.getModifiers());
//            System.out.println(method.getReturnType());//得到方法返回类型的Class对象
//            Class<?>[] parameterTypes = method.getParameterTypes();//返回形参类型的Class对象
//        }
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor.getName());
            System.out.println(constructor.getModifiers());
            Class[] parameterTypes = constructor.getParameterTypes();
        }
    }
    @Test
    public void api1() throws Exception {
        Class<?> aClass = Class.forName("com.wqf.reflection.utils.Person");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getModifiers());//以int类型返回修饰符
            //默认修饰符: 0, public: 1, private: 2, protected: 4, static: 8, final: 16
            System.out.println(field.getType());//返回的是属性的类型对应的类的Class对象
            System.out.println(field.getName());//返回属性名
        }
    }
    @Test
    public void api() throws Exception {
        Class<?> aClass = Class.forName("com.wqf.reflection.utils.Person");
        aClass.getName();//得到全类名 com.wqf.reflection.utils.Person
        aClass.getSimpleName();//得到简单类名 Person
        Field[] fields = aClass.getFields();//得到所有的public属性,包括父类
        Field[] declaredFields = aClass.getDeclaredFields();//得到所有的属性,包括父类
        Method[] methods = aClass.getMethods();//得到所有public方法,包括父类
        Method[] declaredMethods = aClass.getDeclaredMethods();//得到所有方法,包括父类
        Constructor<?>[] constructors = aClass.getConstructors();//得到所有public构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();//得到所有的构造器
        aClass.getPackage();//得到包信息
        Class<?> superclass = aClass.getSuperclass();//返回父类class对象
        Class<?>[] interfaces = aClass.getInterfaces();//得到public接口
        Annotation[] annotations = aClass.getAnnotations();//得到注解信息
    }
}
class Person {
    public String name;
    protected int age;
    String job;
    private double sal;

    public void m1() {}
    protected void m2() {}
    void m3() {}
    private void m4() {}
}
