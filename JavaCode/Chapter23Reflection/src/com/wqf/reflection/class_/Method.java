package com.wqf.reflection.class_;

import java.lang.reflect.Field;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Method {

    public static void main(String[] args) throws Exception {

        String classAllPath = "com.wqf.Car";
        //1. 获取car类对应的对象
        //<?>表示不确定的java类型
        Class<?> aClass = Class.forName(classAllPath);
        //2. 输出aClass
        System.out.println(aClass);//显示aClass对象是哪个类的Class对象 com.wqf.Car
        System.out.println(aClass.getClass());//输出运行类型 java.lang.Class
        //3. 得到包名
        System.out.println(aClass.getPackage().getName());
        //4. 得到全类名
        System.out.println(aClass.getName());
        //5. 通过Class对象创建实例对象
        Object car = aClass.newInstance();
        //6. 通过Class对象得到公有属性
        Field brand = aClass.getField("brand");
        System.out.println(brand.get(car));
        //7. 通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));
        //8. 通过反射得到所有公有的属性
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}
