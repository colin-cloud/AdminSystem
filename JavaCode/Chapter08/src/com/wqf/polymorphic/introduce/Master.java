package com.wqf.polymorphic.introduce;

public class Master {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Master(String name) {
        this.name = name;
    }

    //使用多态机制，可以统一管理主人喂食问题
    //animal编译类型是Animal，可以接收它的子类型
    //food同样如此
    public void feed(Animal animal, Food food) {
        System.out.println("主人 " + this.name + " 给小狗" + animal.getName() + " 喂食" + food.getName());
    }

//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人 " + this.name + " 给小狗" + dog.getName() + " 喂食" + bone.getName());
//    }
//    //如果动物很多，食物很多
//    //feed方法很多，不利于管理和维护
//    //---------->多态
}
