import java.util.*;

public class CountAndSay { 
    public static void main(String[] args) { 
     
    }
    
    public String countAndSay(int n) {
        String str1 = "1";
        int num = 0;
        char ch;
        for (int k = 0; k < n - 1; k++) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str1.length(); ) {
                num = 1;
                ch = str1.charAt(i);
                i++;
                while (i < str1.length() && str1.charAt(i) == ch) {
                    num++;
                    i++;
                }
                //找到第一个与前一个字符不相同的字符
                //进行添加
                sb.append(num + "" + ch);
            }
            str1 = sb.toString();
        }
        return str1;
    }
}
}