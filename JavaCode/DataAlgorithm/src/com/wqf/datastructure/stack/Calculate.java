package com.wqf.datastructure.stack;

/**
 * @author 小白学java
 * @version 3.0
 * 模拟计算器计算
 */
public class Calculate {

    public static void main(String[] args) {

        //创建两个栈
        ArrStack numStack = new ArrStack(10);
        ArrStack operaStack = new ArrStack(10);
        //中缀表达式
        String str = "70*8-1";
        String num = "";//用于判断多位数
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean bool = ArrStack.isOperator(ch);
            if (bool) {
                if (operaStack.size() == 0) {
                    //如果符号栈中的大小为0，直接入栈
                    operaStack.add(ch);
                } else {
                    //如果不为0，则判断与栈顶的运算符的优先级大小
                    char pop = (char)operaStack.peek();
                    if (ArrStack.getPriority(pop) - ArrStack.getPriority(ch) < 0) {
                        //说明栈内的运算符优先级小
                        //直接入栈
                        operaStack.add(ch);
                    } else {
                        //向数字栈中取出两个数进行运算
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        char opera = (char) operaStack.pop();
                        int calculate = ArrStack.calculate(num1, num2, opera);
                        numStack.add(calculate);
                        operaStack.add(ch);
                    }
                }
            } else {
                //如果是数字那么就直接入数字栈
//                numStack.add(ch - 48);//个位数
                num += ch;
                while (true) {
                    if (++i < str.length()) {
                        char at = str.charAt(i);
                        if (!ArrStack.isOperator(at)) {
                            num += at;
                        } else {
                            i--;
                            break;
                        }
                    } else {
                        i--;
                        break;
                    }
                }
                numStack.add(Integer.parseInt(num));
                num = "";
            }
        }
        //入栈操作完毕后
        for (int i = 0; i < operaStack.size(); i++) {
            char opera = (char)operaStack.pop();
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int calculate = ArrStack.calculate(num1, num2, opera);
            numStack.add(calculate);
        }

        //最后得到的就是结果
        System.out.println("result = " + numStack.pop());
    }
}

class ArrStack {
    private int top = -1;
    //栈的最大大小
    private int maxSize;
    //数组模拟栈
    private int[] stack;

    public ArrStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //栈的大小
    public int size() {
        return top + 1;
    }
    //查看栈顶
    public int peek() {
        return stack[top];
    }
    //入栈
    public void add(int num) {
        //判断栈是否满
        if (top == maxSize - 1) {
            System.out.println("栈满，无法添加数据~");
            return;
        }
        top++;
        stack[top] = num;
    }
    //出栈
    public int pop() {
        //判断栈内是否有元素
        if (top == -1) {
//            System.out.println("栈空，无法取出数据~");
//            return -1;
            throw new RuntimeException("栈空，无法取出数据~");
        }
        int res = stack[top];
        top--;
        return res;
    }
    //遍历栈
    public void list() {
        //判断栈空
        if (top == -1) {
            System.out.println("栈空");
            return;
        }
        int temp = top;
        while (temp >= 0) {
            System.out.println(stack[temp]);
            temp--;
        }
    }
    //判断运算符的优先级
    public static int getPriority(char operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;//只考虑加减乘除
        }
    }
    //判断是运算符还是数字
    public static boolean isOperator(char operator) {
        return operator == '*' || operator == '/' || operator == '+' || operator == '-';
    }
    //进行两个数字的运算
    public static int calculate(int num1, int num2, char operator) {
        int res = 0;
        switch (operator) {
            case '*' :
                res = num1 * num2;
                break;
            case '/' :
                res = num2 / num1;
                break;
            case '+' :
                res = num1 + num2;
                break;
            case '-' :
                res = num2 - num1;
                break;
            default :
                break;
        }
        return res;
    }
}
