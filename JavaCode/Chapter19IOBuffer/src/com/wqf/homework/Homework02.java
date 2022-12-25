package com.wqf.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework02 {

    public static void main(String[] args) throws IOException {

        String filePath = "D:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\exercise.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String str = null;
        int count = 1;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str + "行号:" + count);
            count++;
        }
        bufferedReader.close();
    }
}
