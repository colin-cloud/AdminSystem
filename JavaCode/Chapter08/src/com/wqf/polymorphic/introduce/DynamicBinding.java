package com.wqf.polymorphic.introduce;

public class DynamicBinding {

    public static void main(String[] args) {

        A1 a = new B1();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}

class A1 {
    //动态绑定机制：
    public int i = 20;

    public int sum() {
        return i + 20;
    }
    public int getI() {
        return i;
    }
    public int sum1() {
        return i + 10;
    }
}

class B1 extends A1 {
    public int i = 20;

    public int sum() {
        return i + 20;
    }
    public int getI() {
        return i;
    }
//    public int sum1() {
//        return i + 10;
//    }
}
