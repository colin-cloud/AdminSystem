package com.wqf.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class MergeSort {

    public static void main(String[] args) {

//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] temp = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 80000000);
        }
        int[] temp = new int[ints.length];
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为:" + time1);
        mergeSort(ints, 0, ints.length - 1, temp);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为:" + time2);
    }
    //归并排序
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            //向左进行分割
            mergeSort(arr, left, mid, temp);
            //向右进行分割
            mergeSort(arr, mid + 1, right, temp);
            //进行合并
            merge(arr, left, mid, right, temp);
        }
    }
    //合并

    /**
     *
     * @param arr 需要排序的数组
     * @param left 左索引
     * @param mid 中间索引
     * @param right 右索引
     * @param temp 临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //定义索引
        int l = left;
        int r = mid + 1;
        int index = 0;
        //将左右的数组进行比较并放入临时数组中
        while (l <= mid && r <= right) {
            //左边索引为l的小于右边索引为r的
            if (arr[l] <= arr[r]) {
                temp[index] = arr[l];
                l++;
            } else {
                temp[index] = arr[r];
                r++;
            }
            index++;
        }
        //将左右中剩余的数值放到临时数组中
        while (l <= mid) {
            temp[index] = arr[l];
            l++;
            index++;
        }
        while (r <= right) {
            temp[index] = arr[r];
            r++;
            index++;
        }
        //将temp拷贝到原数组中
        index = 0;
        int keepLeft = left;
        while (keepLeft <= right) {
            arr[keepLeft++] = temp[index++];
        }
    }
}
