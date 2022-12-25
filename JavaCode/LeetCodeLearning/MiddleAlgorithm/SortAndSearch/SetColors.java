import java.util.*;

public class SortColors { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroCount = 0;
        int twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 2) {
                twoCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < zeroCount) {
                nums[i] = 0;
            } else if (i < nums.length - twoCount) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
    
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //定义双指针，p0指向第一个1的位置，p1指向最后一个1的后一个位置
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                p1++;
            } else if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                //如果p0小于p1,说明需要将一个1向后面移动一位
                if (p0 < p1) {
                    int tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p0++;
                p1++;
            }
        }
    }
    
}