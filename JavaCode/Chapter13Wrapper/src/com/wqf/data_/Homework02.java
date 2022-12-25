package com.wqf.data_;

import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        displaySpecialFormat(name);
    }
    public static void displaySpecialFormat(String name) {

        String[] str = name.split(" ");
        String anotherNane = str[str.length - 1].concat(",");
        anotherNane = anotherNane.concat(str[0] + ".");
        String tmp = str[str.length - 2].substring(0, 1);
        anotherNane = anotherNane.concat(tmp );
        System.out.println(anotherNane);
    }
}
