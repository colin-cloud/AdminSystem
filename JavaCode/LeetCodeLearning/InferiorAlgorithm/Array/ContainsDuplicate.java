import java.util.*;

public class ContainsDuplicate { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public boolean contaisDuplicate(int[] nums) {
    
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean containsDuplicate(int[] nums) {
        
        //使用哈希表
        Set<Integer> hashset = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!hashset.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}