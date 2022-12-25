package com.wang.pkg;

import java.util.Arrays;
//将java.util 下的所有类都导入 java.util.*;
//将java.util 下的Scanner导入 java.util.Scanner;
//建议用什么类导入什么类
public class Import {

    public static void main(String[] args) {

        //使用系统提供的Arrays完成数组排序
        int[] array = {-1, 20, 2, 13, 5};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
