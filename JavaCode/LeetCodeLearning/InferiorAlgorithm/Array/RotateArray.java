import java.util.*;

public class Rotate { 
    public static void main(String[] args) { 
        
    }
    
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }
    
    public void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] copyNums = new int[len];
        for (int i = 0; i < len; i++) {
            copyNums[(i + k) % len] = nums[i];
        }
        for (int j = 0; j < len; j++) {
            nums[j] = copyNums[j];
        }
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}