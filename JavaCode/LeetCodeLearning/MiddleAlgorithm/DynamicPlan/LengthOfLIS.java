import java.util.*;

public class LengthOfLIS { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length, maxLen = 1;
        //创建dp数组，dp[i]表示以nums[i]结尾的最大子序列长度
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            //默认为1
            dp[i] = 1;
            //遍历i前面的序列
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    
    public int lengthOfLIS(int[] nums) {
        
    }
}