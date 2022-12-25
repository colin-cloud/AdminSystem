package com.wqf.qqclient_view;

import com.wqf.qqClientcommon.service.ClientService;
import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 */
//客户端的显示界面
public class QQView {
    private String choose;//定义选择变量
    private boolean loop = true;//定义循环变量
    Scanner scanner = new Scanner(System.in);//接收输入
    private ClientService clientService = new ClientService();

    public static void main(String[] args) {
        new QQView().virtualMenuFirst();
    }
    //显示界面(一级菜单)
    private void virtualMenuFirst() {
        while (loop) {
            System.out.println("=========欢迎使用网络通信系统=========");
            System.out.println("\t\t 1. 登录系统");
            System.out.println("\t\t 9. 退出系统");
            System.out.print("请输入你的选择: ");
            choose = scanner.next();
            switch (choose) {
                case "1" :
                    //登录
                    System.out.print("请输入用户名: ");
                    String userId = scanner.next();
                    System.out.print("请输入密 码: ");
                    String password = scanner.next();
                    //进行用户身份的验证,写一个类专门服务于服务端进行身份的验证
                    if (clientService.isLogin(userId, password)) {
                        //进入二级菜单，向服务端发送信息，表示想要接收离线消息
                        virtualMenuSecond(userId);
                    } else {
                        //返回到一级菜单
                        System.out.println("登录失败, 请重新选择");
                    }
                    break;
                case "9" :
                    System.out.println("退出系统...");
                    loop = false;
                    break;
                default :
                    System.out.println("输入错误");
                    break;
            }
        }
    }
    //显示二级菜单
    private void virtualMenuSecond(String userId) {
        System.out.println("欢迎您用户(" + userId + ")");
        while (loop) {
            System.out.println("=========网络通信系统二级菜单=========");
            System.out.println("\t\t 1. 显示在线用户列表");
            System.out.println("\t\t 2. 群发消息");
            System.out.println("\t\t 3. 私聊消息");
            System.out.println("\t\t 4. 发送文件");
            System.out.println("\t\t 9. 退出系统");
            System.out.print("请输入你的选择: ");
            choose = scanner.next();
            switch (choose) {
                case "1" :
                    clientService.sendMesToGetList();
                    //二级菜单刷新太快，将系统休眠一会儿
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2" :
                    //群发消息
                    System.out.print("请输入你想发送给大家的信息: ");
                    String content1 = scanner.next();
                    clientService.sendMesToAllPeople(content1);
                    break;
                case "3" :
                    //进行私聊
                    clientService.sendMesToGetList();
                    //二级菜单刷新太快，将系统休眠一会儿
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("请选择要进行聊天的在线对象: ");
                    String userName = scanner.next();
                    System.out.print("请输入想要说的内容: ");
                    String content = scanner.next();
                    clientService.sendMesToUser(userName, content);
                    break;
                case "4" :
                    //发送文件
                    System.out.print("请输入想发送文件的用户ID: ");
                    String UID = scanner.next();
                    System.out.print("请输入发送的文件的完整路径(形式如: d:\\xxx.jpg): ");
                    String filePathMine = scanner.next();
                    System.out.print("请输入发送文件到对方的路径: ");
                    String filePathAnother = scanner.next();
                    clientService.sendFileToUser(filePathMine, filePathAnother, UID);
                    break;
                case "9" :
                    clientService.sendMesToExit();
                    System.out.println("退出系统...");
                    loop = false;
                    break;
                default :
                    System.out.println("输入错误");
                    break;
            }
        }
    }
}
