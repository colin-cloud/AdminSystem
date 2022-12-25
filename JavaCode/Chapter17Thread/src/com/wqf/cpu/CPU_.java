package com.wqf.cpu;

/**
 * @author 小白学java
 * @version 1.0
 */
public class CPU_ {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }
}
