package com.wqf.final_.exercise;

public class Exercise01 {

    public static void main(String[] args) {

        System.out.println(new Circle(2).S());
    }
}

class Circle {
    private double radius;
    private final double PI = 3.14;

    public final double S() {
        return PI * radius * radius;
    }
    {
//        PI = 3.14;
    }
    public Circle(double radius) {
        this.radius = radius;
        //PI = 3.14
    }
}
