package com.wqf.single;

public class SingleTon01 {

    public static void main(String[] args) {

        GirlFriend girlFriend = GirlFriend.getInstance();
        System.out.println(girlFriend);
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
        System.out.println(instance == girlFriend);
    }
}

class GirlFriend {

    private String name;
    //为了能够在静态方法中返回对象需要static修饰
    private static GirlFriend girlFriend = new GirlFriend("小花");
    //如何保证只能创建一个对象
    //1. 构造器私有化
    //2. 在类的内部创建
    //3. 提供一个公共static的方法返回对象
    private GirlFriend(String name) {
        this.name = name;
    }
    //不创建对象使用
    public static GirlFriend getInstance() {
        return GirlFriend.girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}