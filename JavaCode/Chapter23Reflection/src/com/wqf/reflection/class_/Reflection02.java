package com.wqf.reflection.class_;

import java.lang.reflect.Method;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Reflection02 {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.wqf.reflection.class_.Person");
        Object obj = aClass.newInstance();
        Method method = aClass.getMethod("hi", String.class);
        method.invoke(obj, "wqf");
        //调用private static 方法对象
        Method method1 = aClass.getDeclaredMethod("say", int.class, String.class, char.class);
        method1.setAccessible(true);
        System.out.println(method1.invoke(obj, 10, "wqf", 'c'));
    }
}
class Person {
    public int age;
    private static String name;
    public Person() {
    }
    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }
    public void hi(String s) {
        System.out.println("hi" + s);
    }
}