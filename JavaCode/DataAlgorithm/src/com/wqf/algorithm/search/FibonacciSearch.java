package com.wqf.algorithm.search;

import java.util.Arrays;

/**
 * @author 小白学java
 * @version 3.0
 */
public class FibonacciSearch {

    //斐波那契数列
    public static int maxSize = 20;
    public static int[] f = new int[maxSize];

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibonacciSearch(arr, 1234));
    }

    //斐波那契查找
    public static int fibonacciSearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0;
        int mid = 0;
        //得到斐波那契数列
        int[] f = fib();
        //寻找k值
        while (right > f[k] - 1) {
            k++;
        }
        //如果f[k] 大于 right 就对数组进行扩容
        int[] temp = Arrays.copyOf(arr, f[k]);
        //对数组进行填充
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        //进行查找
        while (left <= right) {
            mid = left + f[k - 1] - 1;
            if (value < temp[mid]) {
                right = mid - 1;
                k--;
            } else if (value > temp[mid]) {
                left = mid + 1;
                k -= 2;
            } else {
                //相等
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }
    //斐波那契数列
    public static int[] fib() {
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
