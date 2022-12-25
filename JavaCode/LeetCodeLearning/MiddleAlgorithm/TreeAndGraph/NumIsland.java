import java.util.*;

public class NumIsland { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
   
    public int numIslands(char[][] grid) {
        //判断图是否为空
        if (grid == null || grid.length == null) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        //进行遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    //如果当前位置为陆地，那么就进行深度优先遍历
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int row, int col) {
        //判断当前的行和列是否合法
        if (row < 0 || row > grid.length || col < 0 || col > gird[0].length) {
            return;
        }
        //将当前的位置设置为已访问
        grid[row][col] = '2';
        //进行深度优先遍历
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
    }
    
    public int numIsland(char[][ grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length, count = 0;
        //进行广度优先遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    //将当前位置设置为已访问
                    grid[i][j] = '2';
                    count++;
                    //创建队列保存相邻结点
                    Queue<Integer> queue = new LinkedList();
                    queue.offer(i * rows + j);
                    //进行遍历
                    while (!queue.isEmpty()) {
                        int total = queue.poll();
                        int row = total / rows;
                        int col = total % rows;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '2';
                            queue.offer((row - 1) * rows + col);
                        }
                        if (col + 1 < cols && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '2';
                            queue.offer(row * rows + col + 1);
                        }
                        if (row + 1 < rows && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '2';
                            queue.offer((row + 1) * rows + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '2';
                            queue.offer(row * rows + col - 1);
                        }
                    }
                }
            }
        }
        return count;
    }
}