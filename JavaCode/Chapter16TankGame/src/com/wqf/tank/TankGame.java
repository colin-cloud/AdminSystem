package com.wqf.tank;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 */
public class TankGame extends JFrame {

    private MyPanel myPanel = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[]  args) throws IOException {

        new TankGame();
    }
    public TankGame() throws IOException {
        //初始化面板
        System.out.println("请输入选择 1: 新游戏 2:继续上局");
        String choose = scanner.next();
        myPanel = new MyPanel(choose);
        //将面板放到Thread启动
        new Thread(myPanel).start();
        //把面板放入都框架
        this.add(myPanel);
        this.addKeyListener(myPanel);
        //设置窗口大小
        this.setSize(1300, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    //退出前将myPanel中敌人坦克集合传入给记录板
//                    Recorder.setEnemyTanks(myPanel.getEnemyTanks());
                    Recorder.recordNum();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
    public MyPanel getMyPanel() {
        return myPanel;
    }
}
