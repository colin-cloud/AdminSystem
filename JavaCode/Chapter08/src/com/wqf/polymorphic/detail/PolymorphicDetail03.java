package com.wqf.polymorphic.detail;

public class PolymorphicDetail03 {

    public static void main(String[] args) {

        BB bb = new BB();
        //instanceof 语法
        System.out.println(bb instanceof BB);
        //看的是运行类型
        AA aa = new BB();
        System.out.println(aa instanceof  AA);
        System.out.println(aa instanceof  BB);

        String str = "hello";
//        System.out.println(str instanceof AA);error
    }
}


class AA {

}
class BB extends AA {

}