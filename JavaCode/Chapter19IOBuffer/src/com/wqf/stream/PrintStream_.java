package com.wqf.stream;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author 小白学java
 * @version 1.0
 */
public class PrintStream_ {

    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //默认情况下，PrintStream输出数据的位置是：标准输出，即显示器
        out.print("hello,world");
        /**
         * public void print(String s) {
         *         if (s == null) {
         *             s = "null";
         *         }
         *         write(s);
         *     }
         */
        //print底层是使用write方法
        out.write("hello,world".getBytes());
        out.close();
        //修改打印流输出的位置/设备
        System.setOut(new PrintStream("D:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\a.txt"));
        System.out.println("hello,world");
    }
    @Test
    public void printWriterUse() throws IOException {

        //new PrintWriter(Writer)
        PrintWriter printWriter = new PrintWriter(
                new FileWriter("D:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\a.txt"));
        printWriter.print("hello,world !");
        printWriter.close();
    }
}
