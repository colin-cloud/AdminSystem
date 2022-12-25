package com.wqf.polymorphic.introduce;

public class PolymorphicMethod {

    public static void main(String[] args) {
        A a = new A();
        //方法重载体现多态
        //传入不同的参数，调用了不同的sum方法，体现了多态
        System.out.println(a.sum(10, 20));
        System.out.println(a.sum(10, 20, 30));
        //方法重写体现多态
        B b = new B();
        a.say();
        b.say();
    }
}

class B {
    public void say() {
        System.out.println("B say()被调用...");
    }
}

class A extends B {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    public void say() {
        System.out.println("A say()被调用...");
    }
}
