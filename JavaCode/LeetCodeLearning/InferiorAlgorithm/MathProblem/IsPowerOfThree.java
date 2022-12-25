import java.util.*;

public class HelloWorld { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public boolean isPowerOfThree(int n) {
    
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
    
        for (int i = n; n % 3 == 0; n /= 3) {
            ;
        }
       
        return n == 1;
    }
}