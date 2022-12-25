package com.wqf.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class MethodG extends JFrame {

    private MyPanel myPanel = null;
    public static void main(String[] args) {

        new MethodG();
    }
    public MethodG() {
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
//        g.drawOval(10, 10, 100, 100);
//        //画直线
//        g.drawLine(10, 10, 100,100);
//        //画矩形边框
//        g.drawRect(10, 10, 100, 100);
////        //设置画笔颜色
////        g.setColor(Color.BLUE);
////        //画填充矩形
//        g.fillRect(10, 10, 100, 100);
//        //画填充椭圆
//        g.setColor(Color.BLACK);
//        g.fillOval(10,10, 100, 100);
//        //画图片
//        //1. 获取图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/fbfeaa9e338242eabfc2eb061ef0a276b5e4b099_raw.jpg"));
//        g.drawImage(image, 10, 10, 1080, 1080, this);
//        //画字符串
//        g.setColor(Color.GRAY);
//        g.setFont(new Font("隶书", Font.BOLD, 50));
//        //设置的100， 100是字体的左下角
//        g.drawString("北京", 100, 100);
        g.setColor(Color.blue);
        g.fillRect(100, 100, 10, 100);
        g.fillRect(140, 100, 10, 100);
        g.fillRect(110, 120, 30, 60);
        g.setColor(Color.green);
        g.fillOval(110,135, 30, 30);
        g.drawLine(125, 150, 125,100);
    }
}
