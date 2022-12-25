import java.util.*;

public class CoinChange { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }
    public int coinChange(int[] coins, int amount, int[] res) {
         if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (res[amount - 1] != 0) {
            return res[amount - 1];
        }
        int min = Integer.MIN_VALUE;
        for (int coin : coins) {
            int ans = coinChange(coins, amount - coin, res);
            if (ans >= 0 && ans < min) {
                min = ans + 1;
            }
        }
        res[amount - 1] = (min == Integer.MIN_VALUE) ? -1 : min;
        return res[amount - 1];
    }
    
    public int coinChange(int[] coins, int amount) {
        //设置dp数组的默认值
        int max = amount + 1;
        //dp[i] 表示组成金币i所使用的最小硬币数, 默认为amount+1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        //组成0的硬币数量为0
        dp[0] = 0;
        //遍历金币
        for (int i = 1; i <= amount; i++) {
            //遍历硬币数组
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}