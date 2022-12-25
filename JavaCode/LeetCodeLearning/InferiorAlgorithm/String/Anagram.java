import java.util.*;

public class Anagram { 
    public static void main(String[] args) { 
        
    }
    
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        Map<Character, Integer> hashtable = new HashMap();
        for (int i = 0; i < sLen; i++) {
           char c = s.charAt(i);
           hashtable.put(c, hashtable.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < tLen; j++) {
            char c = t.charAt(j);
            hashtable.put(c, hashtable.getOrDefault(c, 0) - 1);
            if (hashtable.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isAnagram(String s, String t) {
        //先转化为数组
        if (s.length() != t.length()) {
            return false;
        }
        
        
        char[] sChs = s.toCharArray();
        char[] tChs = t.toCharArray();
        
        Arrays.sort(sChs);
        Arrays.sort(tChs);
        
        return sChs.equals(tChs);
    }
    
    public boolean isAnagram(String s, String t) {
    
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] chNums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index1 = s.charAt(i) - 'a';
            int index2 = t.length(i) - 'a';
            chNums[index1]++;
            chNums[index2]--;
        }
        return chNums.equals(new int[26]);
    }
}