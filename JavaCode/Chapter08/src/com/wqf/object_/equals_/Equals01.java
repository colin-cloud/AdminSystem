package com.wqf.object_.equals_;

public class Equals01 {

    public static void main(String[] args) {

//        A a = new A();
//        A b = a;
//        A c = b;
//        System.out.println(a == c);
//        B bObj = a;
//        System.out.println(bObj == b);
//        //查看源码ctrl + b
//        "hello".equals("abc");
        Integer integer = new Integer(5);
        Integer integer1 = new Integer(5);
        System.out.println(integer == integer1);
        System.out.println(integer.equals(integer1));

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
class B{}
class A extends B {}