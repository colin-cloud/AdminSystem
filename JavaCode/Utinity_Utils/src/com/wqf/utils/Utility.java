package com.wqf.utils;

import java.util.Scanner;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    //输出指定长度的字符串,默认字符串为string
    public static String scanString(int length, String string) {
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("")) {
                return string;
            }
            if (str.length() <= length) {
                return str;
            }
            System.out.println("输入错误,请重新输入！");
        }
    }
    //输入一个整形,最大为maxInt
    public static int scanInt(int maxInt) {
        while (true) {
            String str = scanner.nextLine();
            int num= 0;
            try {
                num = Integer.parseInt(str);
                if (num <= maxInt) {
                    return num;
                }
                System.out.println("输入不符合预定,请重新输入！");
            } catch (NumberFormatException e) {
                System.out.println("输入类型错误,请重新输入!");
            }
        }
    }
    public static char scanChar() {
        while (true) {
            String str = scanner.nextLine();
            if (str.length() == 1) {
                return str.charAt(0);
            }
            System.out.println("输入错误,请重新输入！");
        }
    }
    public static double scanDouble() {
        while (true) {
           String str = scanner.nextLine();
            try {
                double parseDouble = Double.parseDouble(str);
                return parseDouble;
            } catch (NumberFormatException e) {
                System.out.println("输入类型错误,请重新输入！");
            }
        }
    }
}
