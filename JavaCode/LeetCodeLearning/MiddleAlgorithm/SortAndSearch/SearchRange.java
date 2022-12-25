import java.util.*;

public class SearchRange { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                break;
            }
        }
        int[] res = {-1,-1};
        if (left <= right) {
            if (mid - 1 < 0) {
                res[0] = 0;
            } else {
                for (int i = mid - 1; i >= 0; i--) {
                    if (nums[i] != target) {
                        res[0] = i + 1;
                        break;
                    }
                    if (i == 0) {
                        res[0] = 0;
                    }
                }
            }
            if (mid + 1 >= nums.length) {
                res[1] = nums.length - 1;
            } else {
                for (int i = mid + 1; i < nums.length; i++) {
                    if (nums[i] != target) {
                        res[1] = i - 1;
                        break;
                    }
                    if (i == nums.length - 1) {
                        res[1] = nums.length - 1;
                    }
                }
            }
        }
        return res;
    }
}
