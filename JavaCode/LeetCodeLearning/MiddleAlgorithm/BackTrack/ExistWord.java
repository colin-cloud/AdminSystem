import java.util.*;

public class ExistWord { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        boolean[][] bools = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == w[0]) {
                   if (w.length == 1 || exit(board,w,i,j,0,bools)){
                return true;
            }
                }
            }
        }
        return false;
    }
    public boolean exit(char[][] board, char[] w, int i, int j, int index,boolean[][] bools) {
        bools[i][j] = true;
        if (index == w.length) {
            return true;
        }
        if (board[i][j] == w[index]) {
            if (index == w.length - 1) {
            return true;
        }
            if (i - 1 >= 0 && !bools[i-1][j]&&exit(board, w,i-1,j,index+1,bools)) {
            return true;
        } else if (i+ 1<board.length && !bools[i+1][j]&&exit(board,w,i+1,j,index+1,bools)){
            return true;
        } else if(j-1>=0&&!bools[i][j-1]&&exit(board,w,i,j-1,index+1,bools)){
            return true;
        } else if(j+1<board[i].length&&!bools[i][j+1]&&exit(board, w,i,j+1,index+1,bools)){
            return true;
        } else {
                bools[i][j] = false;
            return false;
        }
        } else {
            bools[i][j] = false;
            return false;
        }
    }
}
