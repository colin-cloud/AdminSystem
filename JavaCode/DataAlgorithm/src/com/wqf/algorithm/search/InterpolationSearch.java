package com.wqf.algorithm.search;

/**
 * @author 小白学java
 * @version 3.0
 */
public class InterpolationSearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 7, 8, 10, 22};
        System.out.println(interpolationSearch(arr, 0, arr.length - 1, 7));
    }

    public static int interpolationSearch(int[] arr, int value) {
        //非递归二分查找
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        if (value < arr[left] || value > arr[right]) {
            return -1;
        }
        while (left <= right) {
            mid = left + (value - arr[left]) * (right - left) / (arr[right] - arr[left]);
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

    public static int interpolationSearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        //没找到的情况
        if (left > right || value < arr[left] || value > arr[right]) {
            return -1;
        }
        if (arr[mid] > value) {
            //说明value在数组的左边
            return interpolationSearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return interpolationSearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
