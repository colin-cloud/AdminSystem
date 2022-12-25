package com.wqf.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class BubbleSort {

    public static void main(String[] args) {

//        int[] arr = {3, 9, -1, 10, -2};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        //创建一个80000大小的数组进行测试
        int[] ints = new int[80000];
        for (int i = 0; i < 80000; i++) {
            ints[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为:" + format);
        //进行排序
        bubbleSort(ints);
        Date date2 = new Date();
        String format1 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为:" + format1);
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean bool = false;
        //时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    bool = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //冒泡排序的优化-如果在一趟排序中，一次交换都没有进行过，就可以提前退出循环
            if (!bool) {
                return;
            }
            bool = false;
        }
    }
}
