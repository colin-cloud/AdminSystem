package com.use;

import com.xiaoqiang.Dog;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);
        //使用的包名进行区分不同Dog类
        com.xiaoming.Dog dog1 = new com.xiaoming.Dog();
        System.out.println(dog1);
        System.out.println(Math.abs(1));
    }
}
