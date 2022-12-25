package com.wqf.codeblock.detail;

public class CodeBlockDetail {

    public static void main(String[] args) {

//        //创建对象
//        AA aa = new AA();
//        //创建子类时，父类也会被加载
//        //使用类的静态成员时
//        int num = Cat.n;
//        //子类被加载，父类必定会被加载，而且会被优先加载
//        AA aa1 = new AA();
//        //静态代码块只会被执行一次
        System.out.println(DD.n);
        //静态代码块的执行优先于静态成员的使用
    }
}
class DD {
    public static int n = 2;
    static {
        System.out.println("DD 的静态代码块被执行...");
    }
    {
        System.out.println("DD 的普通代码块被执行...");
    }
}
class Animal {
    static {
        System.out.println("Animal 静态代码块被执行...");
    }
}

class Cat extends Animal {
    public static int n = 888;

    static {
        System.out.println("Cat 的静态带买块被执行..");
    }
}

class BB {
    static {
        System.out.println("BB 的静态代码块被执行..");
    }
}

class AA extends BB {

    //静态代码块
    static {
        System.out.println("AA 的静态代码块被执行...");
    }
}

