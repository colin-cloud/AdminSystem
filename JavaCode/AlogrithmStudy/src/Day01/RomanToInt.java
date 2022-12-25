package Day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
public class RomanToInt {

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     *
     * @param s 传入一个罗马字符串
     * @return 返回一个罗马数字
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> romanIntMap = new HashMap();
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);
        int romanInt = 0;
        char[] chars = s.toCharArray();
        int j = chars.length - 1;
        while (j >= 0) {
            if (j + 1 < chars.length) {
                //判断后面字符与当前字符的大小
                if (romanIntMap.get(chars[j + 1]) > romanIntMap.get(chars[j])) {
                    //减去当前的数
                    romanInt -= romanIntMap.get(chars[j]);
                } else {
                    //加上当前的数
                    romanInt += romanIntMap.get(chars[j]);
                }
            } else {
                romanInt += romanIntMap.get(chars[j]);
            }
            j--;
        }
        return romanInt;
    }
}
