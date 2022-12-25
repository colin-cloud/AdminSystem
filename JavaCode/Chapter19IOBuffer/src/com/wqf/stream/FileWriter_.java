package com.wqf.stream;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * @author 小白学java
 * @version 1.0
 */
public class FileWriter_ {

    public static void main(String[] args) {

    }
    @Test
    public void writerFile() throws IOException {

        FileWriter fileWriter = null;
        char[] buffer = new char[1024];
        int readLength = 0;
        String filePath = "D:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\write.txt";
        try {
            fileWriter = new FileWriter(filePath);
            String str = "风雨过后，必将彩虹";
            fileWriter.write(str.toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }
}
