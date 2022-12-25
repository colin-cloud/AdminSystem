package com.wqf.algorithm.kmp;

/**
 * @author 小白学java
 * @version 3.0
 */
public class KMPDemo {

    public static void main(String[] args) {

        String str1 = "12345";
        String str2 = "34";
        int match = KMP(str1, str2);
        System.out.println(match);
    }

    //kmp匹配字符串
    public static int KMP(String originalStr, String matchStr) {
        //得到部分匹配值
        int[] matchVal = getMatchValue(matchStr);
        for (int i = 0, j = 0; i < originalStr.length(); i++) {
            while (j > 0 && originalStr.charAt(i) != matchStr.charAt(j)) {
                j = matchVal[j - 1];
            }
            if (originalStr.charAt(i) == matchStr.charAt(j)) {
                j++;
            }
            if (j == matchStr.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    //得到部分匹配值
    public static int[] getMatchValue(String matchStr) {
         //创建新的数组来保存部分匹配值
        int[] matchVal = new int[matchStr.length()];
        matchVal[0] = 0;
        for (int i = 1, j = 0; i < matchStr.length(); i++) {
            while (j > 0 && matchStr.charAt(i) != matchStr.charAt(j)) {
                j = matchVal[j - 1];
            }
            if (matchStr.charAt(i) == matchStr.charAt(j)) {
                j++;
            }
            matchVal[i] = j;
        }
        return matchVal;
    }

    //暴力匹配字符串
    public static int violentMatch(String originalStr, String matchStr) {
        char[] originalCh = originalStr.toCharArray();
        char[] matchCh = matchStr.toCharArray();
        int i = 0;
        int keepI = i;
        int j = 0;
        while (i < originalCh.length && j < matchCh.length) {
            if (originalCh[i] == matchCh[j]) {
                i++;
                j++;
            } else {
                i = keepI + 1;
                keepI = i;
                j = 0;
            }
        }
        if (j == matchCh.length) {
            return keepI;
        } else {
            return -1;
        }
    }
}
