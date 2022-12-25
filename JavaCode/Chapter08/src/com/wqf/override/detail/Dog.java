package com.wqf.override.detail;

public class Dog extends Animal{
    //因为Object不是String的子类，因此编译错误
    public String m1() {
        return null;
    }
}
