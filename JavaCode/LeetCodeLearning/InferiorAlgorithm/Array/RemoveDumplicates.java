import java.util.*;

public class removeDumplicates { 
    public static void main(String[] args) { 
        
    }
    
    public int removeDumplicates(int[] nums){
        //快慢指针
        int slow = 1;
    
        for (int fast = 0; fast < nums.length - 1; fast++) {
        
            if (nums[fast + 1] == nums[fast]) {
                continue;
            } else {
                nums[slow] = nums[fast + 1];
                index++;
            }
        }
        return slow;
    }
}