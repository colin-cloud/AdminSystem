import java.util.*;

public class IncreasingTriplet { 
    public static void main(String[] args) { 
        int[] nums = {1,5,0,4,1,3};
        System.out.println(increasingTriplet(nums));
    }
    
    public static boolean increasingTriplet(int[] nums) {
        //暴力超时
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //先找到比索引为i的数大的第一个数
            int j = 0;
            for (j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    int k = 0;
                    for (k = j + 1; k < len; k++) {
                        if (nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int[] leftMin = new int[len];
        leftMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[len];
        rightMax[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}