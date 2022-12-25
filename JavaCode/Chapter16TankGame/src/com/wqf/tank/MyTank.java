package com.wqf.tank;

import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * @author 小白学java
 * @version 1.0
 */
public class MyTank extends Tank {
    //我方坦克发出的子弹
    private Bullet bullet = null;
    //发出多颗子弹
    private Vector<Bullet> bullets = new Vector<>();

    public MyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    //射击
    public void shotBullet() {
        //设置子弹最大数
        if (bullets.size() == 5) {
            return;
        }
        switch (getDirection()) {
            case 0://上(x + 20, y)
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1://下(x + 20, y + 60)
                bullet = new Bullet(getX() + 20, getY() + 60, 1);
                break;
            case 2://左(x, y + 20)
                bullet = new Bullet(getX(), getY() + 20, 2);
                break;
            case 3://右(x + 60, y + 20)
                bullet = new Bullet(getX() + 60, getY() + 20, 3);
                break;
            default:
                System.out.println("输入错误");
        }
        //启动线程
        bullets.add(bullet);
        new Thread(bullet).start();
    }
}
