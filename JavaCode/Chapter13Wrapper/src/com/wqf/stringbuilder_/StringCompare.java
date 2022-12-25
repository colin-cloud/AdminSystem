package com.wqf.stringbuilder_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 小白学java
 * @version 1.0
 */
public class StringCompare {

    public static void main(String[] args) {

        Integer arr[] = {1, -1, 0, 2, 6};
//        Arrays.sort(arr, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Integer o11 = (Integer)o1;
//                Integer o12 = (Integer)o2;
//                return o12 - o11;
//            }
//        });
        bubbleSortCustom(arr, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
        int index = Arrays.binarySearch(arr, 0);
        System.out.println(index);
    }

    public static void bubbleSortCustom(Integer[] arr, Comparator comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    Integer integer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = integer;
                }
            }
        }
    }
}
