import java.util.*;

public class  { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int missingNumber(int[] nums) {
        int[] copyNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            copyNums[nums[i]] = 1;
        }
        int j = 0;
        for ( ; j < copyNums.length; j++) {
            if (copyNums[j] == 0) {
                break;
            }
        }
        return j;
    }
    
    public int missingNumber(int[] nums) {
        //使用位运算^ -> 一个数异或两次等于自己
        int ret = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            ret ^= nums[i];
        }
        for (int j = 0; j <= len; j++) {
            ret ^= j;
        }
        return ret;
    }
    
    public int missingNumber(int[] nums) {
        //使用求和的方式
        int ans = (nums.length + nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            ans -= nums[i];
        }
        return ans;
    }
    
    public int missingNumber(int[] nums) {
        //数组排序
        Arrays.sort(nums);
        int ret = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}