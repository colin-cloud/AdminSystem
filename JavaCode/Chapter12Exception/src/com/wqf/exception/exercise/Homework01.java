package com.wqf.exception.exercise;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework01 {

    public static void main(String[] args) {

        try {
            //命令行参数不为2，抛出异常
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("传入的参数不对");
            }
            //转换成int类型，抛出异常
            int  integer1 = Integer.parseInt(args[0]);
            int  integer2 = Integer.parseInt(args[1]);
            int res = cal(integer1, integer2);
            System.out.println(res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("输入的参数类型不同");
        } catch (ArithmeticException arithmeticException) {
            System.out.println(arithmeticException.getMessage());
        }
    }
    public static int cal(int n1, int n2) {
        return n1 / n2;
    }
}

