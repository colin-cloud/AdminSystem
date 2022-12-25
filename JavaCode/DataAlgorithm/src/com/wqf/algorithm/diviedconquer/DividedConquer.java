package com.wqf.algorithm.diviedconquer;

/**
 * @author 小白学java
 * @version 3.0
 */
public class DividedConquer {

    public static void main(String[] args) {

        HanoiTower('A', 'B', 'C', 6);
    }

    /**
     * 完成汉诺塔问题 - 将a中的n个盘子全部移动到c中
     * @param a a位置
     * @param b b位置
     * @param c c位置
     */
    public static void HanoiTower(char a, char b, char c, int n) {
        //当a中只有一个盘子的时候
        if (n == 1) {
            System.out.println(a + "->" + c);
            return;
        }
        //当a中有多于两个盘子的时候
        //将上方的n-1个盘子当做一个盘子处理
        HanoiTower(a, c, b, n - 1);
        //直接将a中的最后一个盘子移动到c中
        System.out.println(a + "->" + c);
        //再将b中的n-1个盘子移动到c中
        HanoiTower(b, a, c, n - 1);
    }
}
