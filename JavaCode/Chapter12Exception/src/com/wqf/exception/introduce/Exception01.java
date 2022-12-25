package com.wqf.exception.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exception01 {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 0;
        int res = 0;
        try {
            res = num1 / num2;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());//输出异常信息
        }
        System.out.println(res);
    }
}
