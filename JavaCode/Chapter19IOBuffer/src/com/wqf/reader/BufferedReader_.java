package com.wqf.reader;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author 小白学java
 * @version 1.0
 */
public class BufferedReader_ {

    public static void main(String[] args) {


    }
    @Test
    public void bufferReadFile() throws Exception {
        //创建文件路径
        String filePath = "D:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\exercise.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line = null;
        //按行读取,当返回null时，读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
        /**
         * public void close() throws IOException {
         *         synchronized (lock) {
         *             if (in == null)
         *                 return;
         *             try {
         *                 in.close();
         *             } finally {
         *                 in = null;
         *                 cb = null;
         *             }
         *         }
         *     }
         */
    }
}
