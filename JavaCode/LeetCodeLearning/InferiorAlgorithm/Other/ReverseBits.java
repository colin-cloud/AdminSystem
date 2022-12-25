import java.util.*;

public class ReverseBits { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        sb.reverse();
        while (sb.length() < 32) {
            sb.append('0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }
    
    public int reverseBits(int n) {
        int ret = 0;
        
        for (int i = 0; i < 32 && n != 0; i++) {
            ret |= n & 1;
            n >>> 1;
        }
        return ret;
    }
}