package com.wqf.exception.introduce;

import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exception02 {

    public static void main(String[] args) {

        do {
            try {
                Scanner scanner = new Scanner(System.in);
//                Integer integer = new Integer(scanner.nextInt());
                int num = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("循环");
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } while (true);
    }
}
