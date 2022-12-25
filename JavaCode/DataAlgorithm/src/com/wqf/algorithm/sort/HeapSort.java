package com.wqf.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class HeapSort {

    public static void main(String[] args) {

//        int[] arr = {4, 6, 8, 5, 9};
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] ints = new int[8000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 80000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为:" + time1);
        heapSort(ints);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为:" + time2);
    }

    public static void heapSort(int[] arr) {

        //将数组调整为大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            //进行交换
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将数组调整为大顶堆
     * @param arr 需要调整的数组
     * @param index 需要调整的非叶子结点的索引
     * @param length 数组的大小
     */
    public static void adjustHeap(int[] arr, int index, int length) {
        //保存当前索引下的值
        int value = arr[index];
        //进行循环调整
        //i = 2 * index + 1 表示 左子节点
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            //判断子结点的大小 - 找到最大子结点
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            //判断父结点和子结点大小
            if (arr[i] > value) {
                arr[index] = arr[i];
                //索引往下面移动,继续下面的比较
                index = i;
            } else {
                break;
            }
        }
        arr[index] = value;
    }
}
