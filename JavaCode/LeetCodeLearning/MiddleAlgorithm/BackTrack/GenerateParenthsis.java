import java.util.*;

public class GenerateParenthesis { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        //暴力求解
        generate(new char[2 * n], 0);
        return res;
        
        //使用回溯
        backtrack(new char[2 * n], 0, 0, 0, n);
        return res;
    }
    
    public void generate(char[] chs, int pos) {
        if (pos == chs.length) {
            if (isValid(chs)) {
                res.add(new String(chs));
            }
            return;
        }
        chs[pos] = '(';
        generate(chs, pos + 1);
        chs[pos] = ')';
        generate(chs, pos + 1);
    }
    
    public void backtrack(char[] chs, int open, int close, int pos, int n) {
        if (pos == chs.length) {
            if (isValid(chs)) {
                res.add(new String(chs));
            }
        }
        if (open < n) {
            chs[pos] = '(';
            generate(chs, open + 1, close, pos + 1, n);
        }
        if (close < n) {
            chs[pos] = ')';
            generate(chs, open, close + 1, pos + 1, n);
        }
    }
    
    public boolean isValid(char[] chs) {
        int balance = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
    
}