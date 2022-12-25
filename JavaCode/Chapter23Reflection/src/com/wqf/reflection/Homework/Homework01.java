package com.wqf.reflection.Homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework01 {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.wqf.reflection.Homework.PrivateTest");
        Object object = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(object, "wqf");
        System.out.println(name.get(object));
        Method getName = aClass.getMethod("getName");
        System.out.println(getName.invoke(object));
    }
}
class PrivateTest {
    private String name = "helloKitty";

    public String getName() {
        return name;
    }

}
