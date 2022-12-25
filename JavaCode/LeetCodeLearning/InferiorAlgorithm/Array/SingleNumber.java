import java.util.*;

public class SingleNumber { 
    public static void main(String[] args) {
    
    
    }
    
    
    public int singleNumber(int[] nums) {
        //位运算
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }
}