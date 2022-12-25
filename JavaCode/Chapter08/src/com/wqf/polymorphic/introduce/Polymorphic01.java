package com.wqf.polymorphic.introduce;

public class Polymorphic01 {

    public static void main(String[] args) {
        Dog dog = new Dog("小黄");
        Bone bone = new Bone("骨头");
        Master master = new Master("小王");
        master.feed(dog, bone);
    }
}
