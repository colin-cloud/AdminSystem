package com.wqf.tank;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Bullet implements Runnable {
    private int x;
    private int y;
    private int direction;
    boolean isLive = true;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    @Override
    public void run() {
        //子弹进行自动移动
        while (isLive) {
            bulletMove(x, y, direction);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;
            }
        }
    }
    public void bulletMove(int x, int y, int direction) {
        if (x >= 0 && x <= 1000 && y >= 0 && y <= 750) {
            System.out.println(x + " " + y);
            switch (direction) {
                case 0://上
                    this.setY(y - 2);
                    break;
                case 1://下
                    this.setY(y + 2);
                    break;
                case 2://左
                    this.setX(x - 2);
                    break;
                case 3://右
                    this.setX(x + 2);
                    break;
                default:
                    System.out.println("输入错误");
            }
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
}
