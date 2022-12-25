package com.wqf.final_;

public class Final01 {

    public static void main(String[] args) {

        E e = new E();
    }
}

//如果不希望类被继承
final class A {

}
//class B extends A {
//
//}

class C {
    //如果要求方法不被重写
    public final void hi(){

    }
}
class D extends C {
//    @Override
//    public void hi() {
//        super.hi();
//    }
}

//不希望属性被修改
class E {
    {
        System.out.println("haha");
        RAT_RATE = 0;
    }
    public final double RAT_RATE;
}

class F {
    public void cry() {
        final double NUM = 0.01;//局部常量
//        NUM = 0.9;
        System.out.println(NUM);
    }
}
