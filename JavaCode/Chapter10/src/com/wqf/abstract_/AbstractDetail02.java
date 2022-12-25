package com.wqf.abstract_;

public class AbstractDetail02 {

    public static void main(String[] args) {


    }
}
abstract class D {
    public int n = 10;
    public static String name;
    public void hi() {
        System.out.println("hi");
    }
    public abstract void hello();
}
class E extends D {
    @Override
    public void hello() {
        System.out.println("hello");
    }
}