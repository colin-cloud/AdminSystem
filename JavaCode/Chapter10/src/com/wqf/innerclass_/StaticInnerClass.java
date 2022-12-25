package com.wqf.innerclass_;

public class StaticInnerClass {

    public static void main(String[] args) {

        Outer outer = new Outer();
        outer.hi();
        Outer.Inner inner = new Outer.Inner();
        inner.say();
        Outer.Inner inner1 = Outer.getInner();
        inner1.say();
    }
}
class Outer {
    private int n1 = 10;
    private static String name = "张三";
    public static class Inner {
        public void say() {
            System.out.println(name);
        }
    }
    public void hi() {
        Inner inner = new Inner();
        inner.say();
    }
    public static Inner getInner() {
        System.out.println();
        return new Inner();
    }
}