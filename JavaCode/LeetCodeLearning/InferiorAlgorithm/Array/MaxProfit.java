import java.util.*;

public class MaxProfit { 
    public static void main(String[] args) { 
        
    }
    
    public int maxProfit(int[] prices) {
    
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
    
        //定义一个二维数组
        //列表示当天是否买卖股票，数组值表示当前天以前的利润
        int[][] dp = new int[len][2];
        //1. dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + prices[i]
        //2. dp[i][1] = dp[i - 1][0] - prices[i] + dp[i - 1][1]
        //定义初始值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < len; i++) {
        
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }
    
    public int maxProfit(int[] prices) {
        int min, max, index, len = prices.length, minIndex, profit = 0;
        if (len == 1) {
            return 0;
        }
        index = 0;
        while (index < len) {
            index++;
            //先找到第一个最小的值
            while (index < len && prices[index - 1] > prices[index]) {
                index++;
            }
            minIndex = index - 1;
            if (index == len) {
                break;
            }
            index++;
            while (index < len && prices[index - 1] < prices[index]) {
               index++;
            }
            profit += (prices[index - 1] - prices[minIndex]);
        }
        return profit;
   }
}