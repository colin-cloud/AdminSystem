import java.util.*;

public class Palindrome { 
    public static void main(String[] args) { 
        String s = "\"Sue,\"Tom smiles,\"Selim smote us.\"";
        System.out.println(isPalindrome(s));
    }
    
    public static boolean isPalindrome(String s){
        s = s.toLowerCase();
        
        int len = s.length(), head = 0, end = len - 1;
        char cHead = ' ', cEnd = ' ';
        
        while (head < end) {
            //从前面开始遍历寻找字母
            while (head <= end) {
                cHead = s.charAt(head);
                
                if (isLowerCase(cHead)){
                    
                    break;
                }
                head++;
            }
            
            if (head >= end) {
                
                break;
            }
            System.out.println(cHead);
            //从后面开始寻找字母
            while (end >= head) {
                cEnd = s.charAt(end);
                if (isLowerCase(cEnd)) {
                    break;
                }
                end--;
            }
            System.out.println(cEnd);
            //判断寻找的首尾两个字母是否相等
            if (!(cHead == cEnd)) {
                return false;
            }
            head++;
            end--;
        }
        return true;
    }
    
    public static boolean isLowerCase(char c){
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9'? true : false;
    }
}