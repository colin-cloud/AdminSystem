import java.util.*;

public class GroupAnagrams { 
    public static void main(String[] args) { 
        
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
    
        List<List<String>> res = new ArrayList();
        int i = 0;
        while (i < strs.length) {
        
            if (res.isEmpty()) {
                List<String> list = new ArrayList();
                list.add(strs[i]);
                res.add(list);
            } else {
                String t = strs[i];
                boolean flag = false;
                for (List<String> l : res) {           
                    String s = l.get(0);
                    //判断两个字符串是不是字母异位词
                    if (isAnagram(s, t)) {
                        l.add(t);
                        flag = true;
                    }
                }
                if (!flag) {
                    List<String> l = new ArrayList();
                    l.add(t);
                    res.add(l);
                }
            }
            i++;
        }
        return res;
    }
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChs = s.toCharArray();
        char[] tChs = t.toCharArray();
        Arrays.sort(sChs);
        Arrays.sort(tChs);
        for (int i = 0; i < s.length(); i++) {
            if (sChs[i] != tChs[i]) {
                return false;
            }
        }
        return true;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        //建立映射 - 字符串对应相应的字母异位词列表
        Map<String, List<String>> hashtable = new HashMap();
        int len = strs.length;
        for (String str : strs) {
            //创建字母表
            int[] letters = new int[26];
            for (int i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (letters[i] != 0) {
                    sb.append((char)(i + 'a'));
                    sb.append(letters[i]);
                }
            }
            String s = sb.toString();
            
            hashtable.put(s, hashtable.getOrDefault(s, new ArrayList<String>()));
            hashtable.get(s).add(str);
        }
        return new ArrayList<List<String>>(hashtable.values());
    }
    
    
}