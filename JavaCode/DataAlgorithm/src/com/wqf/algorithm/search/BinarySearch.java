package com.wqf.algorithm.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author 小白学java
 * @version 3.0
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr,1));
    }

    //二分查找
    public static int binarySearch(int[] arr, int value) {
        //非递归二分查找
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (value > arr[mid]) {
                //说明在数组的右边
                left = mid + 1;
            } else if (value < arr[mid]) {
                right = mid - 1;
            } else {
                //返回多个相同的数据
//                ArrayList<Integer> integers = new ArrayList<>();
//                int index = mid - 1;
//                while (index >= 0 && arr[index] == value) {
//                    integers.add(index);
//                }
//                integers.add(mid);
//                index = mid + 1;
//                while (index <= arr.length - 1 && arr[index] == value) {
//                    integers.add(index);
//                }
//                Collections.sort(integers);
                return mid;
            }
        }
        //没有找到
        return -1;
    }

    //递归查找
    public static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        //没找到的情况
        if (left > right) {
            return -1;
        }
        if (arr[mid] > value) {
            //说明value在数组的左边
            return binarySearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
