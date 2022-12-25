import java.util.*;

public class CanJump { 
    public static void main(String[] args) { 
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    
    public static boolean canJump(int[] nums) {
        //动态规划
        int len = nums.length;
        //创建二维数组，其中0表示只走一步，1表示可以走多步
        boolean[][] bools = new boolean[len][2];
        bools[0][1] = true;
        bools[0][0] = true;
        for (int i = 1; i < len; i++) {
            if ((bools[i - 1][0] || bools[i - 1][1])&& nums[i - 1] >= 1) {
                bools[i][0] = true;
            }
            for (int j = 0; j < i; j++) {
                if ((bools[j][0] || bools[j][1]) && nums[j] >= i - j) {
                    bools[i][1] = true;
                    break;
                }
            }
        }
        return bools[len - 1][0] || bools[len - 1][1];
    }
    
    public boolean canJump(int[] nums) {
        //贪心算法来计算能够到达的最大位置
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
