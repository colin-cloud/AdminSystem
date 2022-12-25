package com.wqf.innerclass_;

public class InnerClassExercise02 {

    public static void main(String[] args) {

//        new CellPhone().alarmClock(new Bell() {
//            @Override
//            public void ring() {
//                System.out.println("懒猪起床了");
//            }
//        });
//        new CellPhone().alarmClock(new Bell() {
//            @Override
//            public void ring() {
//                System.out.println("小伙伴上课了");
//            }
//        });
        //有两个需求，可以使用对象
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell {
    void ring();
}
class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}