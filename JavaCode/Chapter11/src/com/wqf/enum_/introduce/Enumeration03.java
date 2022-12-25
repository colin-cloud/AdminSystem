package com.wqf.enum_.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Enumeration03 {

    public static void main(String[] args) {

        System.out.println(SeasonAnother.SPRING);
        System.out.println(SeasonAnother.SUMMER);
        System.out.println(SeasonAnother.AUTUMN);
        System.out.println(SeasonAnother.WINTER);
    }
}
//使用enum关键字来实现枚举

enum SeasonAnother {

//    public static final SeasonAnother SPRING = new SeasonAnother("春天", "温暖");
//    public static final SeasonAnother SUMMER = new SeasonAnother("夏天", "炎热");
//    public static final SeasonAnother AUTUMN = new SeasonAnother("秋天", "凉爽");
//    public static final SeasonAnother WINTER = new SeasonAnother("冬天", "寒冷");
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");
    private String name;
    private String desc;
    //1. 将构造器私有化
    //2. 防止属性被修改，去掉set方法
    //3. 在Season内部直接创建固定对象
    //4. 加入final修饰符
    SeasonAnother(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SeasonAnother{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
