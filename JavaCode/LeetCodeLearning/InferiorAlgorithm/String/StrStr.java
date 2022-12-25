import java.util.*;

public class StrStr { 
    public static void main(String[] args) { 
    
    
    }
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) {
            return -1;
        }
        int id1 = 0, id2 = 0, res = 0;
        char ch1, ch2;
        while (id1 < len1 && id2 < len2) {
            //从前一个字符串中寻找第一个与后一个字符串相同的字符
            while (id1 < len1 && (ch1 = haystack.charAt(id1)) != (ch2 = needle.charAt(id2))) {
                id1++;
            }
            if (id1 == len1) {
                //没有找到
                return -1;
            }
            //找到了
            res = id1;
            id1++;
            id2++;
            while (id1 < len1 && id2 < len2 && (ch1 = haystack.charAt(id1)) == (ch2 = needle.charAt(id2))) {
                id1++;
                id2++;
            }
            if (id2 == len2) {
                return res;
            }
            //匹配失败
            id1 = res + 1;
            id2 = 0;
        }
        return -1;
    }

}