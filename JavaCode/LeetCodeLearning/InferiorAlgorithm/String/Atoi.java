import java.util.*;

public class Atoi { 
    public static void main(String[] args) { 
        String s = " -42";
        System.out.println(myAtoi(s));
    }
    
    public static int myAtoi(String s) {
        //去除前置空格
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' '){
            start++;
        }
        int sign = 1;
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == start && c == '+') {
                sign = 1;
            } else if (i == start && c == '-') {
                sign = -1;
            } else if (isNumber(c)) {
                int num = c - '0';
                if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10) {
                    return Integer.MAX_VALUE;
                } else if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
            } else {
                break;
            }
        }
        return res;
    }
    
    public static boolean isNumber(char c) {
    
        return c >= '0' && c <= '9';
    }
}