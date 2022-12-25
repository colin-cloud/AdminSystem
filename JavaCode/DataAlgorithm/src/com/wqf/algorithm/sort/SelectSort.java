package com.wqf.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class SelectSort {

    public static void main(String[] args) {

//        int[] arr = {3, 9, -1, 10, -2};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
        //测试
        int[] ints = new int[80000];
        for (int i = 0; i < 80000; i++) {
            ints[i] = (int)(Math.random() * 80000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为:" + time1);
        selectSort(ints);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为:" + time2);
    }

    //选择排序
    //思想: 从整个数组中的第i个下标寻找最小值与第i个下标的数进行交换
    public static void selectSort(int[] arr) {
        int min, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            temp = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    temp = j;
                }
            }
            //进行优化 - 当第i个数就是最小值时，不进行交换
            if (temp != i) {
                //进行交换
                arr[temp] = arr[i];
                arr[i] = min;
            }
        }
    }
}
