package com.wqf.datastructure.recursion;

import java.util.regex.Pattern;

/**
 * @author 小白学java
 * @version 3.0
 */
public class EightQueen {

    //定义一个max表示有多少个皇后
    public int max = 8;
    //定义一个数组，保存放置的位置的结果
    public int[] queens = new int[max];
    //定义一个int表示有多少种放置方法
    public static int kind = 0;

    public static void main(String[] args) {

        new EightQueen().getPlace(0);
        System.out.println(kind);
    }
    //进行第n个皇后的摆放
    public void getPlace(int n) {
        //放置成功的条件
        if (n == max) {
            print();
            kind++;
            return;
        }
        //否则，就进行循环比较规则
        for (int i = 0; i < max; i++) {
            //首先将第n个皇后放在该行的第i列中
            queens[n] = i;
            //进行比较规则
            if (isRule(n)) {
                //满足规则
                //进行下一个皇后的摆放
                getPlace(n + 1);
            }
            //否则就进行下一次的循环
        }
    }
    //判断放置的第n个皇后是否符合规则
    public boolean isRule(int n) {
        for (int i = 0; i < n; i++) {
            //满足以下条件就返回false表示不满足规则
            if (queens[n] == queens[i] || Math.abs(queens[n] - queens[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        //否则返回true满足
        return true;
    }
    //打印数组
    public void print() {
        for (int i = 0; i < max; i++) {
            System.out.print(queens[i] + " ");
        }
        System.out.println();
    }
}
