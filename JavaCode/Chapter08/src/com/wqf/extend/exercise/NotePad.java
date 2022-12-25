package com.wqf.extend.exercise;

public class NotePad extends Computer {
    private String color;

    public NotePad(String CPU, String memory, String hardDisk, String color) {
        super(CPU, memory, hardDisk);
        this.setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDetails() {
        return super.getDetails() + this.color;
    }
    public void showInfo() {
        System.out.println(getDetails());
    }
}
