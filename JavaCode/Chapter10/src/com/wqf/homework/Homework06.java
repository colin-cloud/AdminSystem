package com.wqf.homework;

import java.util.zip.CheckedOutputStream;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework06 {

    public static void main(String[] args) {

        Person person = new Person("唐僧", null);
        person.common();
        person.passRiver();
    }
}
interface Vehicles {
    void work();
}
class Horse implements Vehicles{
    public void work() {
        System.out.println("骑马赶路");
    }
}
class Boat implements Vehicles{
    public void work() {
        System.out.println("坐船过河");
    }
}
class VehiclesTraffic {
    //使用饿汉式，马始终都是唯一匹
    private static Horse horse = new Horse();
    private VehiclesTraffic() {

    }
    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
}
class Person{
    private String name;
    private Vehicles vehicles;
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    //将过河和普通情况封装成两个方法
    //不需要手动new
    //判断是否有交通工具以及是什么交通工具
    //充分利用属性
    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesTraffic.getBoat();
        }
        vehicles.work();
    }
    public void common() {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesTraffic.getHorse();
        }
        vehicles.work();
    }
}
