package com.wqf.reflection.test;

import com.wqf.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Reflection {

    public static void main(String[] args) {
        hi();
        m();
    }
    public static void hi() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            cat.hi();

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void m() {
        try {
            Class<?> aClass = Class.forName("com.wqf.Cat");
            Object o = aClass.newInstance();
            Method hi = aClass.getMethod("hi");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000000000; i++) {
                hi.invoke(o);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
