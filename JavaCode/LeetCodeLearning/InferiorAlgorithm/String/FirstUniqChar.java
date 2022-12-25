import java.util.*;

public class FirstUniqChar{ 
    public static void main(String[] args) { 
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
    /**
    public static int firstUniqChar(String s){
    
        //创建映射来保存字符串中对应的字符和索引值
        Map<Character, Integer> hashtable = new HashMap();
        //创建一个与字符串相关联的队列
        Queue<Pair> queue = new LinkedList();
        int i = 0, len = s.length();
        char c;
        
        while (i < len){
            c = s.charAt(i);
            if (!hashtable.containsKey(c)){
                hashtable.put(c, i);
                queue.offer(new Pair(c, i));
            } else {
                hashtable.put(c, -1);
                while (!queue.isEmpty() && hashtable.get(queue.peek().ch) == -1){
                    queue.poll();
                }
            }
            i++;
        }
        return queue.isEmpty() ? -1 : queue.poll().index;
    }
    */
    
    /**
    public static int firstUniqChar(String s){
        //建立字符和索引之间的映射
        Map<Character, Integer> hashtable = new HashMap();
        int i = 0, len = s.length();
        char c;
        
        while (i < len) {
            //得到索引i下的字符
            c = s.charAt(i);
            //判断是否被加入
            if (!hashtable.containsKey(c)) {
                hashtable.put(c, i);
            } else {
                hashtable.put(c, -1);
            }
            i++;
        }
        
        int pos = len;
        //遍历映射，找到第一个独立字符
        for (Map.Entry<Character, Integer> entry : hashtable.entrySet()){
            int val = entry.getValue();
            if (val != -1 && pos > val) {
                pos = val;
            }
        }
        
        return pos == len ? -1 : pos;
    }
    */
    
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        int len = s.length();
        char c;
        
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, i);
            } else {
                map.put(c, -1);
            }
        }
        
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            int pos = map.get(c);
            if (pos != -1) {
                return pos;
            }
        }
        return -1;
    }
}

class Pair {
    char ch;
    int index;
    
    public Pair(char c, int i){
        ch = c;
        index = i;
    }
}