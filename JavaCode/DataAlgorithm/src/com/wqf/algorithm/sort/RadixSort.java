package com.wqf.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class RadixSort {

    public static void main(String[] args) {

//        int[] arr = {53, 3, 542, 748, 14, 214};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 80000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为:" + time1);
        radixSort(ints);
        Date date2 = new Date();
        String time2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为:" + time2);
    }
    //基数排序
    public static void radixSort(int[] arr) {
        //得到数组中的最大数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //得到最大值的位数
        int maxLength = (max + "").length();
        //进行桶排序
        //创建一个二维数组表示桶
        int[][] bucket = new int[10][arr.length];
        //创建一个一维数组表示桶中放入的数的多少
        int[] countsOfBucket = new int[10];

        for (int round = 1; round <= maxLength; round++) {
            //遍历原数组，将数组中的元素放入到桶中
            for (int index = 0; index < arr.length; index++) {
                //得到每一轮的位数的值
                int bitOfElement = arr[index] / (int)(Math.pow(10, round - 1)) % 10;
                //将index索引下的数放入对应桶中
                bucket[bitOfElement][countsOfBucket[bitOfElement]++] = arr[index];
            }
            //遍历每一个桶，将桶中的数据依次存放到原数组中
            int index = 0;
            for (int bucketIndex = 0; bucketIndex < bucket.length; bucketIndex++) {
                for (int count = 0; count < countsOfBucket[bucketIndex]; count++) {
                    arr[index++] = bucket[bucketIndex][count];
                }
                //将桶中的大小置为0
                countsOfBucket[bucketIndex] = 0;
            }
        }
    }
}
