import java.util.*;

public class LetterCombination { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    Map<Character, List<String>> hashtable;
    List<String> res = new ArrayList();
    public List<String> letterCombinations(String digits) {
        putKV();
        int len = digits.length();
        for (int i = 0; i < len; i++) {
            List<String> l = getSubStr(digits.substring(i, len), len);
            if (l.get(0).length() == len) {
                res.addAll(l);
            }
        }
        return res;
    }

    public List<String> getSubStr(String s, int length) {
        int len = s.length();
        if (len == 1) {
            return hashtable.get(s.charAt(0));
        } else {
            List<String> l1 = getSubStr(s.substring(0, len - 1), len);
            if (l1.get(0).length() == len) {
                res.addAll(l1);
            }
            List<String> l2 = hashtable.get(s.charAt(len - 1));
            List<String> ans = new ArrayList();
            for (int i = 0; i < l1.size(); i++) {
                String s1 = l1.get(i);
                for (int j = 0; j < l2.size(); j++) {
                    String s2 = l2.get(j);
                    ans.add(s1 + s2);
                }
            }
            return ans;
        }
    }
    public void putKV() {
        hashtable = new HashMap();
        hashtable.put('2', Arrays.asList(new String[]{"a","b","c"}));
        hashtable.put('3', Arrays.asList(new String[]{"d","e","f"}));
        hashtable.put('4', Arrays.asList(new String[]{"g","h","i"}));
        hashtable.put('5', Arrays.asList(new String[]{"j","k","l"}));
        hashtable.put('6', Arrays.asList(new String[]{"m","n","o"}));
        hashtable.put('7', Arrays.asList(new String[]{"p","q","r","s"}));
        hashtable.put('8', Arrays.asList(new String[]{"t","u","v"}));
        hashtable.put('9', Arrays.asList(new String[]{"w","x","y","z"}));
    }
}