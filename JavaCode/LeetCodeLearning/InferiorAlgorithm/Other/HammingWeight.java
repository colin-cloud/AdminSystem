import java.util.*;

public class HelloWorld { 
    public static void main(String[] args) { 
        hammingWeight(0);
    }
    
    public static int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        
        int index = str.indexOf('1');
        
        if (index == -1) {
            return 0;
        }
        int count = 1;
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
    
    public int hammingWeight(int n) {
        int ret = 0;
        
        for (int i = 0; i < 32; i++) {
            if (n & (1 << i)) {
                ret++;
            }
        }
        return ret;
    }
    
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= (n - 1);
            ret++;
        }
        return ret;
    }
}