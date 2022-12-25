package com.wqf.stringbuilder_;

/**
 * @author 小白学java
 * @version 1.0
 */
public class StringBuilder01 {

    public static void main(String[] args) {

        //1. StringBuilder继承AbstractStringBuilder类
        //2. 实现了Serializable ，说明对象可以串行化(对象可以网络传输，可以保存到文件)
        //3. 是final类，不能被继承
        //4. StringBuilder对象字符序列任然存放在父类的value数组中，存放在堆中
        //5. StringBuilder 的方法，没有做互斥的处理，即没有synchronized关键字，因此在单线程的情况下使用
        StringBuilder stringBuilder = new StringBuilder();
    }
}
