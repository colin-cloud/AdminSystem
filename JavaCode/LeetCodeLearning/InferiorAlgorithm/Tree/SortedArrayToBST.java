import java.util.*;

public class SortedArrayToBST { 
    public static void main(String[] args) { 
        
    }
    
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return null;
        }
        return add(nums, 0, nums.length - 1);
    }
    
    public TreeNode add(int[] nums, int start, int end) {
    
        int mid = start + (end - start) / 2;
        int val = nums[mid];
        
        TreeNode root = new TreeNode(val);
        
        root.left = add(nums, start, mid - 1);
        
        root.right = add(nums, mid, mid + 1);
        
        return root;
    }
}