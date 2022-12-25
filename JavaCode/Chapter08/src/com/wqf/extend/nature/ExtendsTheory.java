package com.wqf.extend.nature;

//继承的本质
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();//首先加载父类 Object -> GrandPa -> Father -> Son
        //按照查找关系来返回信息
        //1). 首先看子类是否有该属性
        //2). 如果子类有这个属性，并且可以访问，则返回信息
        //3). 如果子类没有，就看父类有没有这个属性，如果有且可以访问，返回信息
        //4). 依次往上查找
        System.out.println(son.name);//返回大头儿子
        //System.out.println(son.age); 找到了father类的age但是没有访问权限，直接报错
        System.out.println(son.hobby);//返回GrandPa类的hobby
        System.out.println();
    }
}
