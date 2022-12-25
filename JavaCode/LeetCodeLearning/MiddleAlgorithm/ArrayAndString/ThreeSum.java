import java.util.*;

public class ThreeSum { 
    public static void main(String[] args) { 
    
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
    
        List<List<Integer>> res = new ArrayList();
        //先将数组进行排序
        Arrays.sort(nums);
        //定义左右指针寻找两个数
        int pre = 0, rear = 0;
        int len = nums.length;
        //从左边开始固定一个数，这样就可以只寻找两个数
        for (int i = 0; i < len - 2; i++) {
        
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int fixNum = -nums[i];
            pre = i + 1;
            rear = len - 1;
            while (pre < rear) {
            
                if (nums[pre] + nums[rear] == fixNum) {
            
                    List<Integer> list = new ArrayList();
                    list.add(nums[pre]);
                    list.add(nums[rear]);
                    list.add(-fixNum);
                    res.add(list);
                    pre++;
                    rear--;
                    //过滤相同的结果
                    while (pre < rear && nums[pre] == nums[pre - 1]) {
                        pre++;
                    }
                    while (pre < rear && nums[rear] == nums[rear + 1]) {
                        rear--;
                    }
                } else if (nums[pre] + nums[rear] < fixNum) {
                    pre++;
                } else {
                    rear--;
                }
            }
        }
        return res;
    }
}