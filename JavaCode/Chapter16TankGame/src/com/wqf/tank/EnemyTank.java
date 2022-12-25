package com.wqf.tank;

import java.util.Vector;

/**
 * @author 小白学java
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable {
    //在敌人的坦克里创建一个子弹集合
    Vector<Bullet> bullets = new Vector<>();
    //在敌人坦克类里创建一个坦克集合
    static Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void enemyTankMove(EnemyTank enemyTank) {
        //根据random来决定移动的方向
        enemyTank.setDirection((int) (Math.random() * 4));
    }
    @Override
    public void run() {
        while (isLive()) {
            //进行移动
            if (bullets.size() == 0) {
                Bullet bullet = null;
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
                bullets.add(bullet);
                Thread thread = new Thread(bullet);
                thread.start();
            }

            for (int i = 0; i < 30; i++) {
                if (!isOverlap()) {
                    move();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //随机改变方向
            enemyTankMove(this);
            //写并发程序，一定要考虑线程什么时候结束
        }
    }
    //判断是否发生碰撞
    public boolean isOverlap() {
        //判断当前坦克方向
        switch (getDirection()) {
            case 0://上
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (this != enemyTank) {
                        switch (enemyTank.getDirection()) {
                            case 0:
                            case 1:
                                if ((getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 40
                                        || getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 40)
                                        && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 60) {
                                    return true;
                                }
                                break;
                            case 2:
                            case 3:
                                if ((getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 60
                                        || getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 60)
                                        && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 40) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
            case 1://下
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (this != enemyTank) {
                        switch (enemyTank.getDirection()) {
                            case 0:
                            case 1:
                                if ((getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 40
                                        || getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 40)
                                        && getY() + 60 >= enemyTank.getY() && getY() <= enemyTank.getY() + 60) {
                                    return true;
                                }
                                break;
                            case 2:
                            case 3:
                                if ((getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 60
                                        || getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 60)
                                        && getY() + 60 >= enemyTank.getY() && getY() <= enemyTank.getY() + 40) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
            case 2://左
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (this != enemyTank) {
                        switch (enemyTank.getDirection()) {
                            case 0:
                            case 1:
                                if ((getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 60
                                        || getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 60)
                                        && getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 40) {
                                    return true;
                                }
                                break;
                            case 2:
                            case 3:
                                if ((getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 40
                                        || getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 40)
                                        && getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 60) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
            case 3://右
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (this != enemyTank) {
                        switch (enemyTank.getDirection()) {
                            case 0:
                            case 1:
                                if ((getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 60
                                        || getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 60)
                                        && getX() + 60 >= enemyTank.getX() && getX() + 60 <= enemyTank.getX() + 40) {
                                    return true;
                                }
                                break;
                            case 2:
                            case 3:
                                if ((getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 40
                                        || getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 40)
                                        && getX() + 60 >= enemyTank.getX() && getX() + 60 <= enemyTank.getX() + 60) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
        }
        return false;
    }
}
