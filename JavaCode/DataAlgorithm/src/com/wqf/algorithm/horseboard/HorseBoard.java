package com.wqf.algorithm.horseboard;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
public class HorseBoard {

    public static void main(String[] args) {

        int row = 8;
        int col = 8;
        int[][] chessboard = new int[row][col];
        boolean[][] isVisited = new boolean[row][col];
        int step = 1;
        horseBoard(chessboard, 1, 1, 1, isVisited);
        display(chessboard);
    }

    /**
     * 完成马踏棋盘问题
     * @param chessboard 棋盘
     * @param step 马走的步数
     * @param row 马当前所在的行
     * @param col 马当前所在的列
     * @return 成功就返回true
     */
    public static boolean horseBoard(int[][] chessboard, int step, int row, int col, boolean[][] isVisited) {
        //将当前马的位置设置为当前步数
        chessboard[row][col] = step;
        isVisited[row][col] = true;
        //设定成功的条件
        if (step == chessboard.length * chessboard.length) {
            return true;
        }
        //还没有成功,继续寻找
        //从当前位置寻找下一步可以走的位置
        List<Point> points = getNextPosition(chessboard, row, col);
        sort(points, chessboard);
        while (!points.isEmpty()) {
            //从下一步的位置中取出一个位置
            Point point = points.remove(0);
            if (!isVisited[point.x][point.y]) {
                if (horseBoard(chessboard, step + 1, point.x, point.y, isVisited)) {
                    return true;
                }
            }
        }
        chessboard[row][col] = 0;
        isVisited[row][col] = false;
        return false;
    }

    public static void sort(List<Point> points, int[][] chessboard) {
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int size1 = getNextPosition(chessboard, o1.x, o1.y).size();
                int size2 = getNextPosition(chessboard, o2.x, o2.y).size();
                return size1 - size2;
            }
        });
    }

    public static void display(int[][] chessboard) {
        for (int[] values : chessboard) {
            for (int value : values) {
                System.out.printf("%d", value);
            }
            System.out.println();
        }
    }

    public static List<Point> getNextPosition(int[][] chessboard, int row, int col) {
        //先创建集合
        List<Point> nextSteps = new ArrayList<>();
        //开始寻找
        if (row - 1 >= 0 && col - 2 >= 0) {
            nextSteps.add(new Point(row - 1, col - 2));
        }
        if (row - 2 >= 0 && col - 1 >= 0) {
            nextSteps.add(new Point(row - 2, col - 1));
        }
        if (row - 2 >= 0 && col + 1 < chessboard.length) {
            nextSteps.add(new Point(row - 2, col + 1));
        }
        if (row - 1 >= 0 && col + 2 < chessboard.length) {
            nextSteps.add(new Point(row - 1, col + 2));
        }
        if (row + 1 < chessboard.length && col - 2 >= 0) {
            nextSteps.add(new Point(row + 1, col - 2));
        }
        if (row + 2 < chessboard.length && col - 1 >= 0) {
            nextSteps.add(new Point(row + 2, col - 1));
        }
        if (row + 2 < chessboard.length && col + 1 < chessboard.length) {
            nextSteps.add(new Point(row + 2, col + 1));
        }
        if (row + 1 < chessboard.length && col + 2 < chessboard.length) {
            nextSteps.add(new Point(row + 1, col + 2));
        }
        return nextSteps;
    }
}
