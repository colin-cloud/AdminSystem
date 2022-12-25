package com.wqf.enum_.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Enumeration02 {

    public static void main(String[] args) {

        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

class Season {
    private String name;
    private String desc;

    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    //1. 将构造器私有化
    //2. 防止属性被修改，去掉set方法
    //3. 在Season内部直接创建固定对象
    //4. 加入final修饰符
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
