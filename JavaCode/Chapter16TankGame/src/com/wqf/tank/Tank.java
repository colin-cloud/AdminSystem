package com.wqf.tank;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Tank {

    private int x;
    private int y;
    private int direction;
    private boolean isLive = true;

    public Tank(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        if (direction == 0 && y > 0) {
            y -= 3;
        } else if (direction == 1 && y < 690) {
            y += 3;
        } else if (direction == 2 && x > 0) {
            x -= 3;
        } else if (direction == 3 && x < 940){
            x += 3;
        }
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
