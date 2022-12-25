package com.wqf.reflection.class_;

import com.wqf.Cat;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Class01 {

    public static void main(String[] args) throws Exception {

        //1. 1. Class也是类，因此也继承了Object
        //2. Class类对象不是new出来的，而是系统创建的
        //(1)传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Cat cat = new Cat();
        //(2)反射方式创建对象
        /*  ClassLoader类, 仍然是通过ClassLoader类加在Cat类的Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class<?> aClass = Class.forName("com.wqf.Cat");
        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        //4. 每个类的实力都会记得自己是由哪个Class实例所产生的
        //5. 通过Class可以完整地得到一个类的完整结构，通过一系列的API
        //6. Class对象是存放在堆中的
        //
        //7. 类的字节码二进制数据是放在方法区的，有的地方称为类的元数据(包括方法代码，变量名，方法名，访问权限等)
    }
}
