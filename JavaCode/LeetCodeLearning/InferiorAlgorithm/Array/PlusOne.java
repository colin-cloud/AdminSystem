import java.util.*;

public class PlusOne { 
    public static void main(String[] args) {
    }
    
    public int[] plusOne(int[] digits) {
        
        //判断数组尾数是否为9
        int len = digits.length;
        int rear = len - 1;
        while (rear >= 0 && digits[rear] == 9) {
            //将当前的数改为0
            dights[rear] = 0;
            rear--;
        }
        if (rear < 0) {
            int[] newDigits = new int[len + 1];
            newDigits[0] = 1;
            System.arraycopy(newDigits, 1, digits, 0, len);
            return newDigits;
        } else {
            digits[rear]++;
            return digits;
        }
    }
    
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1]++;
        int endNum = digits[len - 1];
        int b = 0;
        if (endNum < 10) {
            return digits;
        } else {
            //1. 不需要进行数组的扩容
            //将数组的最后一位确定
            digits[len - 1] = endNum % 10;
            for (int i = len - 2; i >= 0; i--) {
                b = ++digits[i];
                if (b < 10) {
                    return digits;
                } else {
                    digits[i] = b % 10;
                }
            }
            int[] newDigits = null;
            if (digits[0] == 0) {
                newDigits = new int[len + 1];
                newDigits[0] = 1;
                for (int i = 1; i < newDigits.length; i++) {
                    newDigits[i] = digits[i - 1]; 
                }
            }
            return newDigits;
        }
    }

}