package com.wqf.extend.detail;

//输入ctrl + h 可以看到类的继承关系
public class Sub extends Base {
    public Sub(String name, int age) {
        //3. detail
        //1). 要调用父类的无参构造器，什么都不写或调用super()
        //super();//父类的无参构造器
        //2). 调用父类的Base(String name) 构造器
        //super(name);
        //3). 调用父类的Base(String name, int age)构造器
        super(name, age);
        System.out.println("子类Sub(String name, int age)构造器被调用...");
    }
    public Sub() {
        //会调用父类的无参构造器
        //super();默认调用
        //3.detail
        super("smith",18);
        System.out.println("子类Sub()构造器被调用...");
    }
    public Sub(String name) {//3.detail
        super("tom", 18);
        System.out.println("子类Sub(String name)构造器被调用...");
    }
    public void say() {
        //父类的私有属性和方法不能直接访问
        //非私有的属性和方法可以直接访问
        System.out.println(n1 + " " + n2 + " " + n3);
        test1();
        test2();
        test3();
        System.out.println("n4 = " + getN4());
        call();
    }

}
