package com.wqf.homework;

public class HomeWork06 {

    public static void main(String[] args) {

        LabeledPoint black_thursday = new LabeledPoint("Black Thursday", 1929, 20.5);
        System.out.println(black_thursday);
    }
}
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
class LabeledPoint extends Point {
    private String label;
    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.setLabel(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' + getX() + getY() +
                '}';
    }
}
