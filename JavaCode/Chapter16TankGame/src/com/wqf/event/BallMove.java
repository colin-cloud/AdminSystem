package com.wqf.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 小白学java
 * @version 1.0
 */
//演示小球通过键盘控制上下减移动
public class BallMove extends JFrame {

    private MyPanel myPanel = null;
    public static void main(String[] args) {

        new BallMove();
    }
    public BallMove() {
        myPanel = new MyPanel();
        this.addKeyListener(myPanel);
        this.add(myPanel);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//KeyListener是一个监听器，监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    //为了让小球可以移动，设置坐标
    private int x = 20;
    private int y = 20;
    //监听键盘的字符输入时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键被按下，该方法触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "被按下...");
        //根据按下的不同键，来进行相应的移动(上下左右键移动)
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            //KeyEvent.VK_DOWN表示向下的箭头对应的code
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        //让面板重绘,调用repaint
        this.repaint();
    }
    //当某个键被释放，该方法调用
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }
}
