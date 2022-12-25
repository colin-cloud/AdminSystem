package com.company.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Solve {

    public static void main(String[] args) {

    }
//    public void solve(char[][] board) {
//        if (board == null || board.length == 0) {
//            return;
//        }
//        int len = board.length;
//        //从数组的边界进行深度优先搜索（且当前元素为'O'）
//        for (int j = 0; j < len; j++) {
//            dfs(board, j, 0);
//            dfs(board, j, board[0].length - 1);
//        }
//        for (int i = 0; i < board[0].length; i++) {
//            dfs(board, 0, i);
//            dfs(board, len - 1, i);
//        }
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                //如果当前元素为'M',就将其还原为'O'
//                if (board[i][j] == 'M') {
//                    board[i][j] = 'O';
//                } else if (board[i][j] == 'O') {
//                    //当前元素为'O',就将其置为'X'
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }
//    public void dfs(char[][] board, int row, int col) {
//        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != 'O') {
//            return;
//        }
//        //当前元素为数组边界的'O',将其置为标记字符'M',并将其相连的'O'也进行标记
//        board[row][col] = 'M';
//        //进行深度优先搜索
//        dfs(board, row - 1, col);
//        dfs(board, row, col + 1);
//        dfs(board, row + 1, col);
//        dfs(board, row, col - 1);
//    }

    public void solve(char[][] board) {
        //广度优先搜索
        if (board == null || board.length == 0) {
            return;
        }
        int len = board.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                //如果当前元素为'O',将其保存
                queue.offer(new int[]{0, i});
                board[0][i] = 'M';
            }
            if (board[len - 1][i] == 'O') {
                queue.offer(new int[]{len - 1, i});
                board[len - 1][i] = 'M';
            }
        }
        for (int i = 0; i < len; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'M';
            }
            if (board[i][board[0].length - 1] == 'O') {
                queue.offer(new int[]{i, board[0].length - 1});
                board[i][board[0].length - 1] = 'M';
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = 'M';
                queue.offer(new int[]{row - 1, col});
            }
            if (col + 1 < board[0].length && board[row][col + 1] == 'O') {
                board[row][col + 1] = 'M';
                queue.offer(new int[]{row, col + 1});
            }
            if (row + 1 < len && board[row + 1][col] == 'O') {
                board[row + 1][col] = 'M';
                queue.offer(new int[]{row + 1, col});
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = 'M';
                queue.offer(new int[]{row, col - 1});
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //如果当前元素为'M',就将其还原为'O'
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    //当前元素为'O',就将其置为'X'
                    board[i][j] = 'X';
                }
            }
        }
    }
}
