import java.util.*;

public class ReverseInt { 
    public static void main(String[] args) { 
        int x = Integer.MIN_VALUE;
        System.out.println(reverse(x));
    }
    /**
    public static int reverse(int x){
        if (x == 0){
            return 0;
        }
        
        boolean flag = false;
        StringBuffer xStr = null;
        if (x < 0){
            xStr = new StringBuffer((x + "").substring(1));
            flag = true;
        }else{
            xStr = new StringBuffer((x + ""));
        }
        
        
        //从尾部开始寻找0，找到最后一个0的位置
        int zeroInd = xStr.length() - 1;
        while (zeroInd >= 0){
            if (xStr.charAt(zeroInd) != '0'){
                break;
            }
            zeroInd--;
        }
        //进行字符串的切割
        String newStr;
        if (!flag){
            newStr = new StringBuffer(xStr.substring(0, zeroInd + 1)).reverse().toString();
        } else {
            newStr = new StringBuffer(xStr.substring(0, zeroInd + 1) + "-").reverse().toString();
        }
        
        long l = Long.parseLong(newStr);
        if (Integer.MAX_VALUE < l || Integer.MIN_VALUE > l){
            return 0;
        }
        
        return (int)l;
    }
    */
    public static int reverse(int x){
        int rev = 0, digit;
        while (x != 0){
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                return 0;
            }
            digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}