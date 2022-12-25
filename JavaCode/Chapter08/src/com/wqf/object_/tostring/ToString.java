package com.wqf.object_.tostring;

public class ToString {

    public static void main(String[] args) {

        //getClass().getName() 类的全类名
        //Integer.toHexString(hashCode())转成十六进制字符串
//        public String toString() {
//            return getClass().getName() + "@" + Integer.toHexString(hashCode());
//        }
//        Integer integer = new Integer(16);
//        System.out.println(Integer.toHexString(integer.hashCode()));
        Monster monster = new Monster("小妖怪", "巡山");
        System.out.println(monster);
        System.out.println(monster);// == monster.toString()
    }
}
class Monster {
    private String name;
    private String job;

    public Monster(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
