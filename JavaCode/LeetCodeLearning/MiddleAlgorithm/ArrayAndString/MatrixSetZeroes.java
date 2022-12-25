import java.util.*;

public class MatrixSetZeroes { 
    public static void main(String[] args) { 
        
    }
    
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrixCopy = new int[m][n];
        for (int i = 0; i < m; i++) {
        
            System.arraycopy(matrix[i], 0, matrixCopy[i], 0, n);
        }
    
        for (int i = 0; i < m; i++) {
        
            for (int j = 0; j < n; j++) {
            
                if (matrixCopy[i][j] == 0) {
                    setZeroes(matrix, i, j);
                }
            }
        }
    }
    
    public void setZeroes(int[][] matrix, int row, int col) {
    
        //将当前的行和列置为0
        for (int i = 0; i < matrix[row].length; i++) {
        
            matrix[row][i] = 0;
        }
        
        for (int j = 0; j < matrix.length; j++) {
        
            matrix[j][col] = 0;
        }
    }
    
    
    public void setZeroes(int[][] matrix) {
    
        int m = matrix.length;
        int n = matrix[0].length;
        setZeroes(matrix, 0, 0, m, n);
    }
    
    public void setZeroes(int[][] matrix, int row, int col, int m, int n) {
        if (row > m - 1) {
            return;
        }
        boolean flag = false;
        if (matrix[row][col] == 0) {
            flag = true;
        }
        if (col < n - 1) {
            setZeroes(matrix, row, col + 1, m, n);
        } else {
            setZeroes(matrix, row + 1, 0, m, n);
        }
        if (flag){
            //将当前的行和列置为0
            for (int i = 0; i < n; i++) {
        
                matrix[row][i] = 0;
            }
        
            for (int j = 0; j < m; j++) {
        
                matrix[j][col] = 0;
            }
        }
    }
    
    public void setZeroes(int[][] matrix) {
    
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public void setZeroes(int[][] matrix) {
    
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                row = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                col = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (col) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
   
}