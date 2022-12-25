package com.wqf.interface_.compare;

public class ExtendsVsInterface {

    public static void main(String[] args) {

        LittleMonkey littleMonkey = new LittleMonkey("悟空");
        littleMonkey.climbing();
        littleMonkey.swimming();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println("猴子会爬树");
    }
}
class LittleMonkey extends Monkey implements Fishablity {
    public LittleMonkey(String name) {
        super(name);
    }

    public void swimming() {
        System.out.println("通过学习" + getName() + "学会了游泳");
    }
}
interface Fishablity {
    void swimming();
}
