package com.wqf.static_.usestatic;

public class ChildGame {

    public static void main(String[] args) {

        Child child1 = new Child("白骨精");
        Child child = new Child("狐狸精");
        Child child2 = new Child("老鼠精");
        System.out.println("一共有" + Child.count + "人加入了游戏");
    }
}

class Child {
    private String name;
    //定义一个count，是一个类变量static修饰
    public static int count = 0;
    //该变量被所有的Child对象共享
    //该变量可以通过类名直接访问(遵循访问原则)

    public Child(String name) {
        this.name = name;
        count++;
        join();
    }
    public void join() {
        System.out.println(name + "加入了游戏");
    }
}