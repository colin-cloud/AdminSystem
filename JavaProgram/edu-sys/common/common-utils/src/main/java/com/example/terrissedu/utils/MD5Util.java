package com.example.terrissedu.utils;

import java.security.MessageDigest;

/**
 * @author Terriss
 * @time 2023-07-06 20:47:33
 * @description TODO
 */
public class MD5Util {

    public static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };


    /** MD5加密
     *
     * @return 加密后的字符串
     **/
    public static String encrypt(String str) {
        try {
            byte[] btInput = str.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] chs = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                chs[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                chs[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            return new String(chs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
