import java.util.*;

public class TopKFrequent { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        //思路:先将数组排序后的前k和数依次放入结果数组中，
        //然后再根据后面的数出现的个数与结果数组中的最小出现次数的值进行比较交换
        int[] nums1 = new int[k];
        int[] nums2 = new int[k];
        Arrays.sort(nums);
        int v = 1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int j1 = i;
            while ((i + 1 < nums.length) && nums[i] == nums[i + 1]) {
                v++;
                i++;
            }
            if (index < k) {
                nums1[index] = nums[i];
                nums2[index] = v;
            } else {
                int val = 0;
                for (int j = 1; j < k; j++) {
                    if (nums2[j] < nums2[val]) {
                        val = j;
                    }
                }
                if (v > nums2[val]) {
                    nums1[val] = nums[i];
                    nums2[val] = v;
                }
            }
            v = 1;
            index++;
            
        }
        return nums1;
    }
}