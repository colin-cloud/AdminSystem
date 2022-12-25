package com.wqf.polymorphic.detail;

public class PolymorphicDetail {

    public static void main(String[] args) {
        //向上转型
        //父类的引用指向了子类的对象
        Animal animal = new Cat();
//        Object obj = new Cat();
        animal.name = "猫";
        System.out.println(animal.name);
        //可以调用父类中的所有成员
        //不能调用子类的特有成员
        //因为在编译阶段，能调用哪些成员是由编译类型来决定的
        //运行阶段时，看的是运行类型，故编译器看的是运行类型中是否有该方法，有则调用，无则寻找相应父类中的方法
        //方法重写中会出现这种情况
        //编译javac - 编译器  运行java - jvm虚拟机
//        animal.eat();
//        animal.run();
//        animal.show();
//        animal.sleep();
        //向下转型
        Cat cat = (Cat)animal;
        System.out.println(cat.name);
        cat.catchMouse();
        //要求父类的引用必须指向的是当前目标类型的对象 - 强转
        //Dog dog = (Dog) animal; error
    }
}
