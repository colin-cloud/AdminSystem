import java.util.*;

//给定一个数组 nums，
//编写一个函数将所有 0 移动到数组的末尾
//同时保持非零元素的相对顺序

public class MoveZeros { 
    public static void main(String[] args) { 
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**
    public static void moveZeros(int[] nums){
        int len = nums.length;
        int first = 0, end = len - 1;
        while (first < end){
            //依次寻找0
            if (nums[first] == 0){
                //将first索引的元素与end进行交换
                nums[first] = nums[end];
                nums[end] = 0;
                int tmp = nums[first];
                int index = first;
                while (index + 1 < end){
                    nums[index] = nums[index + 1];
                    index++;
                }
                nums[index] = tmp;
                end--;
            } else {
                first++;
            }
        }
    }
    */
    /**
    public static void moveZeros(int[] nums){
        int index = 0, len = nums.length;
        
        //将所有的非0数往前移动
        for (int i = 0; i < len; i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        //剩下的元素都为0
        while (index < len){
            nums[index++] = 0;
        }
    }
    */
    
    public static void moveZeros(int[] nums) {
        int numOfZero = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            if (nums[i] == 0){
                numOfZero++;
            } else if (numOfZero != 0){
                nums[i - numOfZero] = nums[i];
                nums[i] = 0;
            }
        }
    }
    
}