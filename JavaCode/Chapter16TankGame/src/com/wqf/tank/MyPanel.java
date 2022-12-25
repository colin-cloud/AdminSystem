package com.wqf.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 小白学java
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {

    private MyTank myTank;
    //坦克会自由移动，坦克之间相互独立，有多线程问题，所以使用Vector集合
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private int size = 3;//集合大小
    //效应按键从而画出子弹
    boolean ifKey = false;
    //定义一个炸弹集合,当子弹打中坦克时加入到集合中
    Vector<Bomb> bombs = new Vector<>();
    //定义3张炸弹图片，用于显示炸弹效果
    Image image1 = null;
    Image image2 = null;
    //定义一个Recorder对象，记录数据
    //定义一个node集合
    private Vector<Node> nodes = new Vector<>();

    public MyPanel(String choose) {
        //游戏开始时加载Node对象集合
        nodes = Recorder.getNodes();
        //判断nodes是否为Null
        if (nodes == null) {
            System.out.println("文件不存在,只能进行新游戏");
            choose = "1";
        }
        //将enemyTanks设置给Record
        Recorder.setEnemyTanks(enemyTanks);
        myTank = new MyTank(500, 200, 0);
        switch (choose) {
            case "1" :
                //创建敌人坦克数量
                for (int i = 0; i < size; i++) {
                    //设置再添加，而不是直接赋值
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0, 1);
                    enemyTank.setEnemyTanks(enemyTanks);
                    //给敌人坦克加入一颗子弹
//            switch (enemyTank.getDirection()) {
//                case 0://上(x + 20, y)
//                    enemyTank.bullets.add(new Bullet(enemyTank.getX() + 20, enemyTank.getY(), 0));
//                    break;
//                case 1://下(x + 20, y + 60)
//                    enemyTank.bullets.add(new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, 1));
//                    break;
//                case 2://左(x, y + 20)
//                    enemyTank.bullets.add(new Bullet(enemyTank.getX(), enemyTank.getY() + 20, 2));
//                    break;
//                case 3://右(x + 60, y + 20)
//                    enemyTank.bullets.add(new Bullet(enemyTank.getX() + 60, enemyTank.getY() + 20, 3));
//                    break;
//                default:
//                    System.out.println("输入错误");
//            }
                    Thread thread1 = new Thread(enemyTank);
                    thread1.start();
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, 1);
                    enemyTank.bullets.add(bullet);
                    //启动敌人坦克射击子弹的线程
                    Thread thread = new Thread(bullet);
                    thread.start();
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2" :
                //继续上局游戏
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY(), node.getDirection());
                    enemyTanks.add(enemyTank);
                    Thread thread1 = new Thread(enemyTank);
                    thread1.start();
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, 1);
                    enemyTank.bullets.add(bullet);
                    //启动敌人坦克射击子弹的线程
                    Thread thread = new Thread(bullet);
                    thread.start();
                    enemyTanks.add(enemyTank);
                }
                break;
            default :
                System.out.println("输入错误");
                break;
        }
        //初始化2张图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/image2.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/image1.jpeg"));
    }

    @Override
    public void run() {
        //每隔100ms重绘子弹
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断子弹是否击中敌方坦克
            for (Bullet bullet : myTank.getBullets()) {
                if (bullet != null && bullet.isLive) {//己方坦克的子弹还存活
                    for (int i = 0; i < enemyTanks.size(); i++) {
                        hitTank(bullet, enemyTanks.get(i));
                        //                    if (!(enemyTanks.get(i).isLive())) {
                        //                        enemyTanks.remove(enemyTanks.get(i));
                        //                    }
                    }
                }
            }
            //判断敌方坦克是否击中我方坦克
            for (EnemyTank enemyTank : enemyTanks) {
                for (Bullet bullet : enemyTank.getBullets()) {
                    if (bullet != null && bullet.isLive) {//敌方坦克的子弹还存活
                        hitTankAnother(bullet, myTank);
                    }
                }
            }
            this.repaint();
        }
    }

    public void displayInfo(Graphics g) {
        //画出玩家成绩的界面
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累计击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, g, 1, 0);
        g.setColor(Color.black);
        g.drawString(Recorder.getShotEnemyTank() + "", 1080, 100);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //显示我方击毁敌方坦克信息
        displayInfo(g);
        if (myTank != null &&myTank.isLive()) {
            drawTank(myTank.getX(), myTank.getY(), g, 0, myTank.getDirection());
        }
        //画出设计出的子弹
        for (int i = 0; i < myTank.getBullets().size(); i++) {
            if (myTank.getBullets().get(i) != null && myTank.getBullets().get(i).isLive != false) {
                g.draw3DRect(myTank.getBullets().get(i).getX(), myTank.getBullets().get(i).getY(),
                        1, 1, false);
            } else {
                myTank.getBullets().remove(myTank.getBullets().get(i));
            }
        }

        //如果炸弹集合中有对象，就绘制炸弹
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 4) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        //绘制敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, 1, enemyTank.getDirection());
                //画出子弹
                for (int j = 0; j < enemyTank.bullets.size(); j++) {
                    Bullet bullet = enemyTank.bullets.get(j);
                    if (bullet.isLive) {
                        g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
                    } else {
                        //从集合中移除子弹对象,否则会一直画
                        enemyTank.bullets.remove(bullet);
                    }
                }
            }
        }
    }

    //绘制坦克
    public void drawTank(int x, int y, Graphics g, int colorType, int direction) {
        switch (colorType) {
            case 0: //己方坦克颜色 - 蓝绿
                g.setColor(Color.cyan);
                break;
            case 1: //敌方坦克颜色 - 黄
                g.setColor(Color.yellow);
                break;
            default:
                System.out.println("输入错误");
        }
        switch (direction) {
            case 0://表示上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1://表示下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 2://表示左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            case 3://表示右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            default:
                System.out.println("方向输入错误");
                break;
        }

    }

    //编写方法判断子弹是否打到坦克
    //什么时候判断子弹是否打中坦克：应该放在run方法中，因为run方法在循环
    public void hitTank(Bullet bullet, EnemyTank enemyTank) {
        switch (enemyTank.getDirection()) {
            case 0:
            case 1:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 40
                        && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 60) {
                    //子弹落入了坦克的范围,将子弹和坦克的存活情况置为false
                    bullet.isLive = false;
                    enemyTank.setLive(false);
                    enemyTanks.remove(enemyTank);
                    //击毁一辆敌方坦克就++
                    Recorder.addShotNum();
                    //创建Bomb对象放入到集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 2:
            case 3:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 60
                        && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 40) {
                    bullet.isLive = false;
                    enemyTank.setLive(false);
                    enemyTanks.remove(enemyTank);
                    //击毁一辆敌方坦克就++
                    Recorder.addShotNum();
                    //创建Bomb对象放入到集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }

    //编写方法，判断敌方坦克子弹击中我方坦克
    public void hitTankAnother(Bullet bullet, MyTank myTank) {
        switch (myTank.getDirection()) {
            case 0:
            case 1:
                if (bullet.getX() > myTank.getX() && bullet.getX() < myTank.getX() + 40
                        && bullet.getY() > myTank.getY() && bullet.getY() < myTank.getY() + 60) {
                    //子弹落入了坦克的范围,将子弹和坦克的存活情况置为false
                    bullet.isLive = false;
                    myTank.setLive(false);
                    //创建Bomb对象放入到集合中
                    Bomb bomb = new Bomb(myTank.getX(), myTank.getY());
                    bombs.add(bomb);
                    myTank = null;
                }
                break;
            case 2:
            case 3:
                if (bullet.getX() > myTank.getX() && bullet.getX() < myTank.getX() + 60
                        && bullet.getY() > myTank.getY() && bullet.getY() < myTank.getY() + 40) {
                    //子弹落入了坦克的范围,将子弹和坦克的存活情况置为false
                    bullet.isLive = false;
                    myTank.setLive(false);
                    //创建Bomb对象放入到集合中
                    Bomb bomb = new Bomb(myTank.getX(), myTank.getY());
                    bombs.add(bomb);
                }
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_S) {
//            myTank.setY(myTank.getY() + 5);
            //这样写不够方便，并且看起来很怪，应当将移动放到Tank中封装成方法
            myTank.setDirection(1);
            myTank.move();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
//            myTank.setY(myTank.getY() - 5);
            myTank.setDirection(0);
            myTank.move();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
//            myTank.setX(myTank.getX() - 5);
            myTank.setDirection(2);
            myTank.move();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//            myTank.setX(myTank.getX() + 5);
            myTank.setDirection(3);
            myTank.move();
        }
        this.repaint();
        if (e.getKeyCode() == KeyEvent.VK_J) {
//            if (myTank.getBullet() != null && myTank.getBullet().isLive == false || myTank.getBullet() == null) {
//                myTank.shotBullet();
//            }
            myTank.shotBullet();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

}
