import java.util.*;

public class TwoSum { 
    public static void main(String[] args) { 
        int[] nums = {3,3};
        int target = 6;
        int[] results = twoSum(nums, target);
        System.out.println(Arrays.toString(results));
    }
    
    public static int[] twoSum(int[] nums, int target) {
        //创建一个map存放数组的值和索引
        Map<Integer, Integer> hashtable = new HashMap();
        int[] results = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++){
            if (hashtable.containsKey(nums[i])){
               return new int[]{i, hashtable.get(target - nums[i])};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
    
}