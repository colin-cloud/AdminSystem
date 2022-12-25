package com.wqf.datastructure.sparseArr;



/**
 * @author 小白学java
 * @version 3.0
 */
public class sparseArray {

    public static void main(String[] args) {
        int[][] ints = new int[11][11];
        ints[1][2] = 1;
        ints[2][3] = 2;
//        print(ints);
        print(getSparseArr(ints));
        print(getOriginalArr(getSparseArr(ints)));
    }

    public static void print(int[][] obj) {
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[i].length; j++) {
                System.out.print(obj[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] getSparseArr(int[][] originalArr) {

        //记录原始数组的行和列和值数目
        int row = originalArr.length;
        int col = originalArr[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (originalArr[i][j] != 0) {
                    num++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArr = new int[num + 1][3];
        //初始化第一行
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = num;
        //初始化后面的内容
        int k = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (originalArr[i][j] != 0) {
                    sparseArr[k][0] = i;
                    sparseArr[k][1] = j;
                    sparseArr[k][2] = originalArr[i][j];
                    k++;
                }
            }
        }
        return sparseArr;
    }

    public static int[][] getOriginalArr(int[][] sparseArr) {

        //得到原始数组的行和列
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        //创建原始数组
        int[][] originalArr = new int[row][col];
        //恢复原始数组
        for (int i = 1; i < sparseArr.length; i++) {
                originalArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return originalArr;
    }
}
