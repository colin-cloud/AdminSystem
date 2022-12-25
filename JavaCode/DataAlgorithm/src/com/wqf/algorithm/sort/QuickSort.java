package com.wqf.algorithm.sort;


import java.util.Arrays;

/**
 * @author 小白学java
 * @version 3.0
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void quickSort(int[] arr, int start, int end) {
        //记录当前的开始和结束的下标
        int s = start;
        int e = end;
        //记录中间的值
        int pivot = arr[(s + e) / 2];
        //用作交换
        int temp = 0;
        while (s < e) {
            //在中间值的左边寻找比它大的值
            while (arr[s] < pivot) {
                s++;
            }
            //在中间值的右边寻找比它小的值
            while (arr[e] > pivot) {
                e--;
            }
            //退出条件
            if (s >= e) {
                break;
            }
            //进行交换
            temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            //进行数值的调整
            if (arr[s] == pivot) {
                e--;
            }
            if (arr[e] == pivot) {
                s++;
            }
        }
        if (s == e) {
            s--;
            e++;
        }
        //递归的条件
        if (start < s) {
            quickSort(arr, start, s);
        }
        if (end > e) {
            quickSort(arr, e, end);
        }
    }
}
