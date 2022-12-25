import java.util.*;

public class ValidSudoku { 
    public static void main(String[] args) { 
        
    }
    
    public boolean isValidSudoku(char[][] board) {
    
        //创建三个数组分别保存行列以及每个九宫格中数字的个数
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int index = board[i][j] - '0' - 1;
                    rows[i][index]++;
                    cols[j][index]++;
                    //第几个九宫格
                    boxes[i / 3][j / 3][index]++;
                    //判断是否有重复的
                    if (rows[i][index] > 1 || cols[j][index] > 1 || boxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}