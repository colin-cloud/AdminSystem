import java.util.*;

public class Rotate { 
    public static void main(String[] args) { 
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
    /**
    public static void rotate(int[][] matrix){
        int len = matrix.length;
        //先将图像进行上下交换
        for (int i = 0; i < len / 2; i++){
            for (int j = 0; j < len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }
        //然后将图像进行对角线交换
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
    */
    public static void rotate(int[][] matrix){
        int len = matrix.length;
        
        for (int i = 0; i < len / 2; i++){
            for (int j = i; j < len - 1 - i; j++){
                int t = matrix[i][j];
                int row = len - 1 - j;
                int col = len - 1 - i;
                matrix[i][j] = matrix[row][i];
                matrix[row][i] = matrix[col][row];
                matrix[col][row] = matrix[j][col];
                matrix[i][col] = t;
            }
        }
    }
}