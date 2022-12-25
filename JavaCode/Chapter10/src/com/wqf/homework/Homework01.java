package com.wqf.homework;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework01 {

    public static void main(String[] args) {

//        int num1 = Frock.getNextNum();
//        int num2 = Frock.getNextNum();
//        System.out.println(num1);
//        System.out.println(num2);
        Frock frock = new Frock();
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        System.out.println(frock.getSerialNumber());
        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
    }
}
class Frock {
    static private int currentNum = 100000;//衣服序号起始值

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }
    private int serialNumber;

    public Frock() {
        serialNumber = getNextNum();
    }
    public int getSerialNumber() {
        return serialNumber;
    }
}