package com.wqf.single;

public class SingleTon02 {

    public static void main(String[] args) {

//        System.out.println(Cat.n);
        Cat instance = Cat.getInstance();
        System.out.println(instance);
        Cat instance1 = Cat.getInstance();
        System.out.println(instance1);
    }
}
//希望在程序进行时，只能创建一个对象
class Cat {

    private String name;

    public static int n = 888;
    private static Cat cat;
    //1. 将构造器私有化
    //2. 创建一个静态属性对象
    //3. 提供一个公共的static方法可以放回一个Cat对象
    private Cat(String name) {
        System.out.println("构造器被调用...");
        this.name = name;
    }
    public static Cat getInstance() {

        if (cat == null) {
            cat = new Cat("小花");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
