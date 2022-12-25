//package com.wqf.homework;
//
///**
// * @author 小白学java
// * @version 1.0
// */
//
//public class Homework05 {
//
//    public static void main(String[] args) {
//
//        Person person = new Person("唐僧", VehiclesTraffic.getHorse());
//        person.work(person.getVehicles());
//        person.setVehicles(new Boat());
//        person.work(person.getVehicles());
//    }
//}
//interface Vehicles {
//    void work();
//}
//class Horse implements Vehicles{
//    public void work() {
//        System.out.println("骑马赶路");
//    }
//}
//class Boat implements Vehicles{
//    public void work() {
//        System.out.println("坐船过河");
//    }
//}
//class VehiclesTraffic {
//    public static Horse getHorse() {
//        return new Horse();
//    }
//    public static Boat getBoat() {
//        return new Boat();
//    }
//}
//class Person{
//    private String name;
//    private Vehicles vehicles;
//    public Person(String name, Vehicles vehicles) {
//        this.name = name;
//        this.vehicles = vehicles;
//    }
//    public void work(Vehicles vehicles) {
//        if (!(vehicles instanceof Horse)) {
//            vehicles = VehiclesTraffic.getHorse();
//        } else {
//            vehicles = VehiclesTraffic.getBoat();
//        }
//        vehicles.work();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Vehicles getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(Vehicles vehicles) {
//        this.vehicles = vehicles;
//    }
//}

