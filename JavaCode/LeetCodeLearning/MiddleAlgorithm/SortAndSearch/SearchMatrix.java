import java.util.*;

public class SearchMatrix { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        //将坐标定位于矩阵右上角
        int rows = matrix.length, row = 0;
        int cols = matrix[0].length, col = cols - 1;
        
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                //将当前坐标的右下角排除掉
                col--;
            } else {
                //向下移动
                row++;
            }
        }
        //向下移动
        return false;
    }
} 