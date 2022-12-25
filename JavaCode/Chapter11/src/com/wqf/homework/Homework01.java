package com.wqf.homework;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework01 {

    public static void main(String[] args) {
        int input = Color.BLUE.ordinal();
        Color blue = Color.BLUE;
        switch(blue) {
            case RED:
                break;
            case BLUE:
                break;
            case BLACK:
                break;
            case GREEN:
                break;
            case YELLOW:
                break;
        }
    }
}
enum Color implements IF {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0,0,0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int yellowValue;
    public void show() {
        System.out.println(redValue + " " + greenValue + " " + yellowValue);
    }
    Color(int redValue, int greenValue, int yellowValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.yellowValue = yellowValue;
    }
}

interface IF {
    void show();
}
