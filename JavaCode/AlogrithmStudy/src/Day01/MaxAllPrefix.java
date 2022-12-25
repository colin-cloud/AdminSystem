package Day01;

import java.io.ObjectInputStream;

/**
 * @author 小白学java
 * @version 3.0
 */
public class MaxAllPrefix {

    public static void main(String[] args) {

        String[] strings = {"ab", "a"};
        System.out.println(longestCommonPrefix(strings));
    }

    /**
     *
     * @param strings 传入一个字符串数组
     * @return 得到最大长度的公共前缀
     */
    public static String longestCommonPrefix(String[] strings) {
        if (strings.length == 1) {
            return strings[0];
        }
        if (strings.length == 0) {
            return "";
        }
        //定义一个字符串来拼接公共前缀
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < strings[0].length(); i++) {
            //从第一个字符串中依次取出字符
            char ch = strings[0].charAt(i);
            //定义一个标志判定是否还要进行前缀判断
            boolean flag = true;
            for (int j = 1; j < strings.length; j++) {
                //进行长度的判断
                if (strings[j].length() < i + 1) {
                    return stringBuilder.toString();
                }
                //从后面的字符串中进行依次的比较
                char nextCh = strings[j].charAt(i);
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
}
