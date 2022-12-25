package com.wqf.transformation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Transformation01 {

    public static void main(String[] args) throws IOException {

        String filePath = "D:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\a.txt";
        String charSet = "gbk";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("你好，世界！");
        bufferedWriter.close();
    }
}
