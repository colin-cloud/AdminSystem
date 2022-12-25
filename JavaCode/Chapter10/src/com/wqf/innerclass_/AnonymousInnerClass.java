package com.wqf.innerclass_;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
//        System.out.println("tiger的运行类型:" + outer04.hashCode());
    }
}

class Outer04 {
    private int n1 = 10;
    public void method() {
        //基于接口的匿名内部类
        //提出一个需求：想使用A接口，并创建A的一个对象
        //传统方式：写一个类，实现改接口，并创建对象
//        Tiger tiger = new Tiger();
//        A a = new Tiger();
//        tiger.cry();
//        a.cry();
        //现在需求为Tiger / Dog 类只是用一次，后面不再使用
        //可以使用匿名内部类来简化开发
        //tiger编译类型：A；运行类型：匿名内部类
        /*
            底层会分配一个名称给这个匿名内部类
            底层会加载该类
            class Outer04$1 implements A {
                public void cry() {
                    System.out.println("老虎在叫唤...");
                }
            }
         */
        //在jdk底层在创建匿名内部类，立即就创建了一个对象，并且把地址返回给tiger
        //匿名内部类只能使用一次，就不能再使用
//        A tiger = new A() {
//            public void cry() {
//                System.out.println("老虎在叫唤...");
//            }
//        };
//        tiger.cry();
//        System.out.println("tiger的运行类型:" + tiger.hashCode());
            //基于类的匿名内部类
//        Father father = new Father("jack") {
//
//        };
        Animal animal = new Animal() {
            //必须要重写匿名的方法
            public void eat() {
                System.out.println("动物吃东西...");
            }
        };
    }
}
//class Tiger implements A {
//    public void cry() {
//        System.out.println("老虎在叫唤....");
//    }
//}
//class Dog implements A {
//    public void cry() {
//        System.out.println("小狗叫唤...");
//    }
//}
interface A {
    public void cry();
}
class Father {
    public Father(String name){
    }
    public void test(){
    }
}
abstract class Animal {
    abstract void eat();
}
