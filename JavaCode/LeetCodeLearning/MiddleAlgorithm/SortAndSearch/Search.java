import java.util.*;

public class Search { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int first = nums[0];
        int mid = -1;
        while (left <= right) {
            mid = (left - right) / 2 + right;
            //判断是否是反转后的索引
            if (nums[mid] < first) {
                //是反转后的索引
                if (nums[mid] < target) {
                    if (first < target) {
                        right = mid - 1;
                    } else if (first == target) {
                        return 0;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] == target) {
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == first) {
                if (nums[mid] == target) {
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                //当前mid索引对应的值没有被反转
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    break;
                } else {
                    if (first > target) {
                        left = mid + 1;
                    } else if (first == target) {
                        return 0;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        if (left > right) {
            return -1;
        } else {
            return mid;
        }
    }
}
