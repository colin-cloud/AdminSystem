package com.wqf.stringbuffer;

/**
 * @author 小白学java
 * @version 1.0
 */
public class StringBuffer02 {

    public static void main(String[] args) {

        //输入一个double值，能够使其用，分割
        double num = 1234567.22;
        //将double转化成StringBuilder
        StringBuilder stringBuilder = new StringBuilder(num + "");
        //使用indexOf方法找到.
        int index = stringBuilder.lastIndexOf(".");
        //每次将索引往前移动三位插入一个,
        for (int i = index - 3; i > 0 ; i -= 3) {
            stringBuilder.insert(i, ',');
        }
        System.out.println(stringBuilder);
    }
}
