import java.util.*;


public class MinStack {

    //声明栈来保存放入的值
    Deque<Integer> stack;
    //创建栈来保存最小值
    Deque<Integer> minStack;


    public MinStack() {
        stack = new LinkedList();
        minStack = new LinkedList();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
//只创建一个栈
class MinStack {

    //创建栈来保存放入值与最小值的差值
    private Deque<Long> minusStack;
    //保存最小值
    private long minVal;

    
    public MinStack() {
        minusStack = new LinkedList();
    }
    
    public void push(int val) {
        if (minusStack.isEmpty(){
            minVal = val;
            minusStack.add(0L);
            return;
        }
        long minus = (long)val - minVal;
        if (minus <= 0) {
            //更新最小值
            minVal = val;
        }
        //将差值放入栈中
        minusStack.push(minus);
    }
    
    public void pop() {
        //判断pop出的值是否为负数
        int minus = minusStack.pop();
        if (minus < 0) {
            //更新最小值
            minVal = minVal - minus;
        }
    }
    
    public int top() {
        long minus = minusStack.peek();
        if (minus <= 0) {
            return (int)minVal;
        }
        return (int)(minVal + minus);
    }
    
    public int getMin() {
        return (int)minVal;
    }
}