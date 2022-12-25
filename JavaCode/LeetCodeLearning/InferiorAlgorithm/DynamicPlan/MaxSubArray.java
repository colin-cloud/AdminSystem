import java.util.*;

public class MaxSubArray { 
    public static void main(String[] args) { 
        
    }
    
    public int maxSubArray(int[] nums){
    
        int maxAns = nums[0], pre = 0;
        for (int i = 1; i < nums.length; i++) {
        
            pre = Math.max(nums[i], nums[i] + pre);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
        
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}