import java.util.*;

public class ReverseString { 
    public static void main(String[] args) { 
        char[] s = {'h','e','l','l','o'};
        reverse(s);
        System.out.println(Arrays.toString(s));
    }
    
    public static void reverse(char[] s){
        int len = s.length, index = 0;
        char ch;
        
        while (index < len / 2){
            ch = s[index];
            s[index] = s[len - 1 - index];
            s[len - 1- index] = ch;
            index++;
        }
    }
}