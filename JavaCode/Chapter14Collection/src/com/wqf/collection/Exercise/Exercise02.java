package com.wqf.collection.Exercise;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 小白学java
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Exercise02 {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Car("宝马", 100000));
        arrayList.add(new Car("奔驰", 100000));
        arrayList.add(new Car("奥拓", 100000));
        System.out.println(arrayList.remove(0));
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        arrayList.clear();
        System.out.println(arrayList);
        ArrayList list = new ArrayList();
        list.add(new Car("宝马", 100000));
        list.add(new Car("奔驰", 100000));
        list.add(new Car("奥拓", 100000));
        arrayList.addAll(list);
        System.out.println(arrayList);
        arrayList.removeAll(list);
        System.out.println(arrayList);
        arrayList.addAll(list);
        for (Object obj : arrayList) {
            System.out.println(obj);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
