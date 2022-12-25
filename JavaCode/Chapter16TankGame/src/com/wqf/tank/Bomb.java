package com.wqf.tank;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Bomb {
    //炸弹
    private int x;
    private int y;
    int life = 9;//炸弹的声明周期
    boolean isLife = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //减少生命值
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLife = false;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
