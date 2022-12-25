package com.wqf.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class ShellSort {

    public static void main(String[] args) {

//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为:" + s);
        shellSort(ints);
        Date date2 = new Date();
        String s1 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为:" + s1);
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        //移位法
//        for (int i = arr.length / 2; i >= 1; i /= 2) {
//            //i表示步长
//            //将数组分成i组
//            //将这i组分别进行插入排序
//            for (int j = 0; j < i; j++) {
//                //表示分的组数
//                for (int k = j; k + i < arr.length; k += i) {
//                    int insertVal = arr[k + i];
//                    int insertIndex = k + i;
//                    while (insertIndex - i >= 0 &&
//                            insertIndex >= j && arr[insertIndex - i] > insertVal) {
//                        arr[insertIndex] = arr[insertIndex - i];
//                        insertIndex -= i;
//                    }
//                    arr[insertIndex] = insertVal;
//                }
//            }
//        }
        for (int i = arr.length / 2; i >= 1; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int insertVal = arr[j];
                int insertIndex = j;
                if (arr[insertIndex] < arr[insertIndex - i]) {
                    while (insertIndex - i >= 0 && insertVal < arr[insertIndex - i]) {
                        arr[insertIndex] = arr[insertIndex - i];
                        insertIndex -= i;
                    }
                    arr[insertIndex] = insertVal;
                }
            }
        }
        //交换法
//        int temp = 0;
//        for (int i = arr.length / 2; i >= 1; i /= 2) {
//            //步长
//            for (int j = i; j < arr.length; j++) {
//                for (int k = j - i; k >= 0; k -= i) {
//                    if (arr[k] > arr[k + i]) {
//                        temp = arr[k];
//                        arr[k] = arr[k + i];
//                        arr[k + i] = temp;
//                    }
//                }
//            }
//        }
    }
}
