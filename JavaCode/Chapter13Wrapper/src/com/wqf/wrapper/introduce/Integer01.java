package com.wqf.wrapper.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Integer01 {

    public static void main(String[] args) {

        //演示int <--> Integer的装箱和拆箱
        //jdk5前是手动装箱拆箱
        //手动装箱
        int n = 100;
        Integer integer = new Integer(n);
        Integer integer1 = Integer.valueOf(n);
        //手动拆箱
        int i = integer.intValue();
        //jdk5以后就可以自动装箱和拆箱
        int n1 = 200;
        //自动装箱
        Integer integer2 = n1;//底层使用的是Integer.valueOf(n1)
        //自动拆箱
        int n2 = integer2;//底层使用的是integer.intValue()
    }
}
