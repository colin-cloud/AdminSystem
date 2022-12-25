package com.wqf.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class InsertSort {

    public static void main(String[] args) {

//        int[] arr = {3, 9, -1, 10, -2};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 80000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为:" + time1);
        insertSort(ints);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为:" + time2);
    }
    //插入排序
    public static void insertSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                if (arr[i + 1] < arr[j]) {
//                    //这个数要放在j的前面
//                    int temp = arr[i + 1];
//                    for (int k = i + 1; k > j; k--) {
//                        arr[k] = arr[k - 1];
//                    }
//                    arr[j] = temp;
//                }
//            }
//        }
        for (int i = 1; i < arr.length; i++) {
            //记录需要插入的第i个数
            int temp = arr[i];
            int index = i - 1;
            //进行判断并移位
            while (index >= 0 && temp < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            //循环终止时就是需要插入的位置
            if (index + 1 != i) {
                arr[index + 1] = temp;
            }
        }
    }
}
