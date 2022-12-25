package com.wqf.object_.finalize_;

//要是finalize的用法
public class Finalize {

    public static void main(String[] args) {

        Car car = new Car("宝马");
        car = null; //car对象就是一个垃圾，垃圾回收器就会回收这个对象，在销毁对象前，会调用该对象的finalize方法，
                    // 可以在这个方法中写自己的业务逻辑代码(比如释放资源：数据库连接，或者打开文件...)
                    //如果不重写finalize，那么就会调用Object类的finalize方法，默认处理
        System.gc();//主动调用垃圾回收期
    }
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }
    //  重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        //super.finalize();//默认调用Object类的方法
        System.out.println("释放了汽车" + name + "....");
    }
}
