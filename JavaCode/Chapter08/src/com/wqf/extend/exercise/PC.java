package com.wqf.extend.exercise;

public class PC extends Computer {
    private String brand;
    //
    //体现了继承设计的基本思想
    public PC(String CPU, String memory, String hardDisk, String brand) {
        super(CPU, memory, hardDisk);
        this.setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getDetails() {
        return super.getDetails() + this.brand;
    }

    public void showInfo() {
        System.out.println(getDetails());
    }
}
