package com.wqf.interface_.introduce;

public class Interface02 {

}
interface AnotherInterface {
    public int n1 = 10;
    public void hi();
    //在接口中，抽象方法可以省略abstract
    //在jdk8后，可以有默认实现方法，需要使用default关键字修饰
    default public void ok() {
        System.out.println("ok...");
    }
    //可以有静态方法
    static public void cry() {
        System.out.println("cry...");
    }
}
//如果一个类implements实现接口，需要将接口的所有的抽象方法实现
class A implements AnotherInterface {
    @Override
    public void hi() {
        System.out.println("hi~~~");
    }
}