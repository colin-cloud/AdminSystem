package com.wqf.homework;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework04 {

    public static void main(String[] args) {

        A a = new A();
        A.B b = a.new B();
        b.show();
    }
}
class A {
    private String name = "小王";
    class B {
        private String name = "小李";
        public void show() {
            System.out.println(name + " " + A.this.name);
        }
    }
}
