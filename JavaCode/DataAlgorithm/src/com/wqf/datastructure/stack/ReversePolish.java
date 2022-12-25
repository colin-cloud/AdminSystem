package com.wqf.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 小白学java
 * @version 3.0
 */
public class ReversePolish {

    public static void main(String[] args) {
//        String expression = "3 4 + 5 * 6 -";
//        //先将逆波兰表达式转换成list集合
//        List<String> list = getList(expression);
//        System.out.println(calculate(list));
        String expression = "1+((2+3)*4)-5";
        System.out.println(getReverseExpression(expression));
    }
    //将字符串内容存放到list集合当中
    public static List<String> getInfixExpressionList(String string) {
        List<String> list = new ArrayList<String>();
        String str = "";
        for (int i = 0; i < string.length(); i++) {
            char at = string.charAt(i);
            //判断是运算符还是数字
            boolean b = isOperator(at + "");
            if (b) {
                //运算符
                list.add(at + "");
            } else {
                //数字
                //拼接
                str += at;
                //进行下一位的比较
                while (true) {
                    if (++i < string.length()) {
                        //判断后面的是不是数字
                        char c = string.charAt(i);
                        if (!isOperator(c + "")) {
                            //如果还是数字就继续拼接
                            str += c;
                        } else {
                            //不是就返回索引
                            i--;
                            break;
                        }
                    } else {
                        i--;
                        break;
                    }
                }
                list.add(str);
                //字符串进行重新初始化
                str = "";
            }
        }
        return list;
    }
    //由中缀表达式转化为后缀表达式
    public static String getReverseExpression(String expression) {
        Stack<String> numStack = new Stack<String>();
        Stack<String> operaStack = new Stack<String>();
        List<String> list = getInfixExpressionList(expression);
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            //判断字符串是数字还是运算符
            boolean bool = isOperator(str);
            if (bool) {
                //运算符
                //判断是不是括号
                if (str.equals("(")) {
                    //如果是左括号，就直接入符号栈
                    operaStack.add(str);
                } else if (str.equals(")")) {
                    //如果是右括号，依次弹出符号栈中的运算符，直到遇到左括号
                    do {
                        numStack.add(operaStack.pop());
                    } while (!operaStack.peek().equals("("));
                    //弹出左括号
                    operaStack.pop();
                } else {
                    if (operaStack.size() == 0 || getPriority(str) > getPriority(operaStack.peek())) {
                        operaStack.add(str);
                    } else {
                        String s = operaStack.pop();
                        numStack.add(s);
                        i--;
                    }
                }
            } else {
                //数字
                //直接入数字栈中
                numStack.add(str);
            }
        }
        //最后再讲运算符栈中的运算符依次移动到数字栈中
        while (operaStack.size() > 0) {
            numStack.add(operaStack.pop());
        }
        //将栈转化成字符串
        String res = "";
        while (numStack.size() > 0) {
            if (numStack.size() == 1) {
                res = numStack.pop() + res;
                break;
            }
            res = " " + numStack.pop() + res;
        }
        return res;
    }
    //将逆波兰表达式转换成list集合
    public static List<String> getList(String expression) {
        String[] strings = expression.split(" ");
        List<String> list = Arrays.asList(strings);
        return list;
    }
    //进行逆波兰表达式的计算
    public static int calculate(List<String> list) {
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            //判断取出的字符串是不是运算符
            String str = list.get(i);
            if (isOperator(str)) {
                int num1 = integers.pop();
                int num2 = integers.pop();
                int calculate = calculate(num1, num2, str);
                integers.add(calculate);
            } else {
                integers.add(Integer.parseInt(str));
            }
        }
        return integers.pop();
    }
    //判断运算符
    public static boolean isOperator(String operator) {
        return operator.equals("*") || operator.equals("/") ||
                operator.equals("+") || operator.equals("-") || operator.equals("(")
                || operator.equals(")");
    }
    //进行欲奴三
    public static int calculate(int num1, int num2, String operator) {
        int res = 0;
        switch (operator) {
            case "*" :
                res = num1 * num2;
                break;
            case "/" :
                res = num2 / num1;
                break;
            case "+" :
                res = num1 + num2;
                break;
            case "-" :
                res = num2 - num1;
                break;
            default :
                break;
        }
        return res;
    }
    //判断运算符的优先级
    public static int getPriority(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 1;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 0;
        } else {
            return -1;//只考虑加减乘除
        }
    }
}
