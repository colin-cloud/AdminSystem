import java.util.*;

public class LengthOfLongestSubstring { 
    public static void main(String[] args) { 
    
    }
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> hashtable = new HashMap();
        int pre = 0, rear = 0, len = s.length(), length = 0, max = 0;
        while (pre < len && rear < len) {
            char cRear = s.charAt(rear);
            hashtable.put(cRear, hashtable.getOrDefault(cRear, 0) + 1);
            if (hashtable.get(cRear) > 1) {
                pre++;
                rear = pre;
                hashtable.clear();
                length = 0;
            } else {
                rear++;
                length++;
                max = Math.max(length, max);
            }
        }
        return max == 0 ? length : max;
    }
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        Set<Character> set = new HashSet();
        int rear = 0, max = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rear < len && !set.contains(s.charAt(rear))) {
                set.add(s.charAt(rear));
                rear++;
            }
            max = Math.max(max, rear - i + 1);
        }
        
        return max;
    }
}