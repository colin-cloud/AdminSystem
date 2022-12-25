import java.util.*;

public class HammingDistance { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    public static int hammingDistance(int x, int y) {
    
        if (x == y) {
            return 0;
        }
        int count = 0;
        while (x != 0 || y != 0) {
            String str1 = Integer.toBinaryString(x);
            String str2 = Integer.toBinaryString(y);
            int len1 = str1.length();
            int len2 = str2.length();
            if (str1.charAt(len1 - 1) != str2.charAt(len2 - 1)) {
                count++;
            }
            x /= 2;
            y /= 2;
        }
        return count;
    }
    
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    
    public int hammingDistance(int x, int y) {
        //将数左移直到为0
        int s = x ^ y;
        int ret = 0;
        while (s != 0) {
            ret += s & 1;
            s << 1;
        }
        return ret;
        
        while (s != 0) {
            s &= (s - 1);
            ret++;
        }
    }
    
}