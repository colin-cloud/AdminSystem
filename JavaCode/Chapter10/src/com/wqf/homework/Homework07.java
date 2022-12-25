package com.wqf.homework;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework07 {

    public static void main(String[] args) {

        Car car = new Car();
        Car.Air air = car.new Air();
    }
}

class Car {
    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("吹冷气");
            } else if (temperature < 0) {
                System.out.println("吹暖气");
            } else {
                System.out.println("关闭空调");
            }
        }
    }
//    public void adjustment() {
//        class Air {
//            public void flow() {
//                if (temperature > 40) {
//                System.out.println("吹冷气");
//                } else if (temperature < 0) {
//                    System.out.println("吹暖气");
//                } else {
//                    System.out.println("关闭空调");
//                }
//            }
//        }
//        Air air = new Air();
//        air.flow();
//    }
}