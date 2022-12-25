package com.wqf.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class DrawCircle extends JFrame {//JFrame对应一个窗口

    //定义一个面板
    private MyPanel myPanel = null;
    public static void main(String[] args) {

        new DrawCircle();
        System.out.println("退出程序");
    }
    public DrawCircle() {
        //初始化面板
        myPanel = new MyPanel();
        //把面板放入都框架
        this.add(myPanel);
        //设置窗口大小
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//1. 先定义一个MyPanel 继承 JPanel
class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) {//绘图方法
        System.out.println("paint()方法被调用");
        super.paint(g);//调用父类的方法进行初始化
        g.drawOval(10, 10, 100, 100);
    }
}
