import java.util.*;

public class LongestCommonPrefix { 
    public static void main(String[] args) { 
        
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1 ) {
            return strs[0];
        }
        if (strs.length == 0) {
            return "";
        }
        //定义一个字符串来拼接公共前缀
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            //从第一个字符串中依次取出字符
            char ch = strs[0].charAt(i);
            //定义一个标志判定是否还要进行前缀判断
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                //进行长度的判断
                if (strs[j].length() < i + 1) {
                    return stringBuilder.toString();
                }
                //从后面的字符串中进行依次的比较
                char nextCh = strs[j].charAt(i);
                if (ch != nextCh) {
                    //说明当前字符不符合要求
                    flag = false;
                }
            }
            if (!flag) {
                break;
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
    
    public String longestCommonPrefix(String[] strs) {
    
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(strs[i], prefix);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }
    
    public String longestCommonPrefix(String s1, String s2) {
        StringBuffer sb = new StringBuffer("");
        int len = s1.length() > s2.length() ? s2.length() : s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            sb.append(s1.charAt(i));
        }
        return sb.toString();
    }
    
    public String longestCommonPrefix(String[] strs) {
    
        if (strs == null || strs.length == 0) {
            return "";
        }
        
    }
    
    public String commonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = (start + end) / 2;
        String pre = commonPrefix(strs, start, mid);
        String rear = commonPrefix(strs, mid + 1, end);
        
        return longestCommonPrefix(pre, rear);
    }

}