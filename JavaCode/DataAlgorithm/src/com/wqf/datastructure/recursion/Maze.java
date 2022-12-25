package com.wqf.datastructure.recursion;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Maze {

    public static void main(String[] args) {

        //创建迷宫
        int[][] maze = new int[8][7];
        //设定阻碍物 - 1
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        for (int i = 0; i < maze[0].length; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        getRoad(maze, 2, 2);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean getRoad(int[][] maze, int row, int col) {
        //设置完成的条件
        if (maze[6][5] == 2) {
            return true;
        }
        //判断该点可不可走
        if (maze[row - 1][col - 1] == 3 || maze[row - 1][col - 1] == 1 || maze[row - 1][col - 1] == 2) {
            //不可走
            return false;
        } else {
            //假定该点可以走
            maze[row - 1][col - 1] = 2;
            //寻找路 - 上 右 下 左
            if (getRoad(maze, row - 1, col)) {
                return true;
            } else if (getRoad(maze, row, col + 1)) {
                return true;
            } else if (getRoad(maze, row + 1, col)) {
                return true;
            } else if (getRoad(maze, row, col - 1)) {
                return true;
            } else {
                //没有找到路
                //将该点设置为不可走
                maze[row - 1][col - 1] = 3;
                return false;
            }
        }
    }
}
