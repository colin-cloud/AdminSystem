import java.util.*;

public class Permute { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<Integer>());
        return res;
    }
    
    public void backtrack(int[] nums, List<Integer> l) {
        if (l.size() == nums.length) {
            res.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //当前集合拥有当前元素就跳过
            if (l.contains(nums[i])) {
                continue;
            }
            //添加当前元素
            l.add(nums[i]);
            //进行回溯
            backtrack(nums, l);
            //移除末尾元素
            l.remove(l.size() - 1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums, int index) {
        //使用递归方式,思路:从数组尾端依次进行全排列，在进行插入
        List<List<Integer>> ans = new ArrayList();
        if (index == nums.length - 1) {
            List<Integer> l = new ArrayList();
            l.add(nums[index]);
            ans.add(l);
            return ans;
        } else {
            List<List<Integer>> sub = permute(nums, index + 1);
            int count = sub.get(0).size();
            for (int i = 0; i < sub.size(); i++) {
                for (int j = 0; j <= count; j++) {
                    List<Integer> l = new ArrayList(sub.get(i));
                    l.add(j, nums[index]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}