import java.util.*;

public class ClimbStairs { 
    public static void main(String[] args) { 
        
    }
    
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //最后一步走1步或者2步
        //climb[i] = climb[i - 1] + climb[i - 2];
        
        int pre = 1; //当只爬一层楼梯时，只用走一步
        int rear = 2; //当需要爬两层时，有两种方案
        
        for (int i = 3; i <= n; i++) {
            int tmp = pre;
            pre = rear;
            rear += tmp;
        }
        
        return rear;
    }
    
    public int climbStairs(int n) {
    
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        //创建二维数组dp,其中第一列表示最后一步走的是1步，
        //第二列表示最后一步走的是2步
        int[][] dp = new int[n][2];
        
        //可得:dp[n - 1][0] = dp[n - 2][0] + dp[n - 2][1];
        //dp[n - 1][1] = dp[n - 3][0] + dp[n - 3][1];
        
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;
        
        for (int i = 3; i <= n; i++) {
            dp[i - 1][0] = dp[i - 2][0] + dp[i - 2][1];
            dp[i - 1][1] = dp[i - 3][0] + dp[i - 3][1];
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}