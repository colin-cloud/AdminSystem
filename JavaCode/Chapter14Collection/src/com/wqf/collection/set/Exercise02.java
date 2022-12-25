//package com.wqf.collection.set;
//
//import java.util.HashSet;
//import java.util.Objects;
//
///**
// * @author 小白学java
// * @version 1.0
// */
//public class Exercise02 {
//
//    public static void main(String[] args) {
//
//        HashSet hashSet = new HashSet();
////        new Employee("jack", 18, )
//    }
//}
//class Employee {
//    private String name;
//    private int age;
//    private MyDate birthday;
//
//    public Employee(String name, int age, MyDate birthday) {
//        this.name = name;
//        this.age = age;
//        this.birthday = birthday;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, birthday);
//    }
//}
//class MyDate {
//    private int year;
//    private int month;
//    private int day;
//
//    public MyDate(int year, int month, int day) {
//        this.year = year;
//        this.month = month;
//        this.day = day;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MyDate myDate = (MyDate) o;
//        return year == myDate.year && month == myDate.month && day == myDate.day;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(year, month, day);
//    }
//}