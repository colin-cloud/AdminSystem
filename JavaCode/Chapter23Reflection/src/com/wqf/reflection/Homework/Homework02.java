package com.wqf.reflection.Homework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework02 {

    public static void main(String[] args) throws
            IOException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, NoSuchMethodException {

        File file = new File("d:\\aa.txt");
        file.createNewFile();
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
    }
}
