package com.wqf.reflection.class_;

import java.lang.reflect.Field;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Reflection001 {

    public static void main(String[] args) throws Exception {

        //1. 得到Student的class对象
        Class<?> aClass = Class.forName("com.wqf.reflection.class_.Student");
        //2. 创建对象
        Object obj = aClass.newInstance();
        System.out.println(obj.getClass());
        //3. 使用反射访问age属性
        Field age = aClass.getField("age");
        age.set(obj, 18);
        System.out.println(age.get(obj));//返回age属性的值
        //4. 使用反射操作name属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj, "wqf");//私有属性不能直接操作，要进行暴破
        //name.set(null, "wqf"):name为static，第一个参数可以为null
        System.out.println(name.get(obj));
        //System.out.println(name.get(null));
    }
}
class Student{
    public int age;
    private static String name;

    public Student(int age) {
        this.age = age;
    }
    public Student() {}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
