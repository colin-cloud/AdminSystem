package com.wqf.algorithm.dynamicplaning;

/**
 * @author 小白学java
 * @version 3.0
 */
public class DynamicPlaning {

    public static void main(String[] args) {

        int[] weight = {1, 3, 4};
        int[] value = {1500, 2000, 3000};
        getOptimalCondition(weight, value, 4);
    }
    //得到最佳的存放情况
    public static void getOptimalCondition(int[] weight, int[] value, int capacity) {
        //创建二维数组来存放各种情况的数据
        int[][] values = new int[weight.length + 1][capacity + 1];
        //创建二维数组来存放最优解
        int[][] select = new int[weight.length + 1][capacity + 1];
        //寻找各种情况的解
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < values[i].length; j++) {
                if (weight[i - 1] > j) {
                    //说明提供的容量不足以放置该物品
                    //从上一行取数据
                    values[i][j] = values[i - 1][j];
                } else {
                    //说明可以放置该物品
                    //将上一行的最优情况与新的情况进行比较
                    if (values[i - 1][j] > value[i - 1] + values[i - 1][j - weight[i - 1]]) {
                        //说明上一行的情况更优
                        values[i][j] = values[i - 1][j];
                    } else {
                        values[i][j] = value[i - 1] + values[i - 1][j - weight[i - 1]];
                        select[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
        for (int i = 0; i < select.length; i++) {
            for (int j = 0; j < select[i].length; j++) {
                System.out.print(select[i][j] + " ");
            }
            System.out.println();
        }
        //寻找最优解
        int maxRow = select.length - 1;
        int maxCol = select[0].length - 1;
        while (maxCol > 0 && maxRow > 0) {
            if (select[maxRow][maxCol] == 1) {
                System.out.println("第" + maxRow + "个物品入背包");
                maxCol -= weight[maxRow - 1];
            }
            maxRow--;
        }
    }
}
