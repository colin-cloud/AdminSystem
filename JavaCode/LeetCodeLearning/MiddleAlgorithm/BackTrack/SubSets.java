import java.util.*;

public class SubSets { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtrack(res, new ArrayList(), 0, nums);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> l, int start, int[] nums) {
        //先将当前集合添加到结果集中
        res.add(new ArrayList(l));
        for (int i = start; i < nums.length; i++) {
            //添加当前数
            l.add(nums[i]);
            //进行dfs
            backtrack(res, l, i + 1, nums);
            //移除当前数
            l.remove(l.size() - 1);
        }
    }
    
    public List<List<Integer>> subSets(int[] nums) {
        //使用位运算
        //得到子集的个数
        int len = 1 << nums.length;
        List<List<Integer>> res = new ArrayList(len);
        for (int i = 0; i < len; i++) {
            List<Integer> l = new ArrayList();
            for (int j = 0; j < nums.length; j++) {
                //判断数每一位是否为1，是1就添加到集合中
                if (((i >> j) & 1) == 1) {
                    l.add(nums[j]);
                }
            }
            res.add(l);
        }
        return res;
    }
    
    public List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        //添加空集
        res.add(new ArrayList());
        for (int i = 0; i < nums.length; i++) {
            //依次遍历整个数组
            for (int j = 0; j < res.size(); j++) {
                //从结果集中依次取出子集
                List<Integer> subList = new ArrayList(res.get(j));
                //对原有的子集进行追加数
                subList.add(subList.size(), nums[i]);
            }
        }
        return res;
    }
}