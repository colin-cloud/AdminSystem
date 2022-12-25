package com.wqf.reflection.class_;

import com.wqf.Car;

/**
 * @author 小白学java
 * @version 1.0
 */
public class GetClass {

    public static void main(String[] args) throws Exception {

        //1. Class.forName
        String classAllPath = "com.wqf.Car";
        Class<?> aClass = Class.forName(classAllPath);
        //2. 类名.class
        Class aClass1 = Car.class;
        System.out.println(aClass1);
        //3. 对象.getClass()
        Car car = new Car();
        Class aClass2 = car.getClass();
        System.out.println(aClass2);
        //4. 通过类加载器获取
        //(1)得到类的加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> aClass3 = classLoader.loadClass(classAllPath);
        System.out.println(aClass3);
        //5. 基本数据类型.class
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        //6. 基本数据类型包装类.TYPE
        Class<Integer> type = Integer.TYPE;
    }
}
