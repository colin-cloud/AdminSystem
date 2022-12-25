package com.wqf.reflection.class_;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Classload {
    public static void main(String[] args) {


    }
}
class A {
    //1. n1是实例属性，不是静态变量，因此在准备阶段是不会分配内存的
    //2. n2是静态变量，会分配内存，进行默认初始化0
    //3. n3是static final，常量变量，一旦分配终生不变
    public int n1 = 10;//1. n1是实例属性，不是静态变量，因此在准备阶段是不会分配内存的
    public static int n2 = 20;//2. n2是静态变量，会分配内存，进行默认初始化0
    public static final int n3 = 30;//3. n3是static final，常量变量，一旦分配终生不变
}
