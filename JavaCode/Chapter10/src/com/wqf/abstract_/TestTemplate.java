package com.wqf.abstract_;

public class TestTemplate {
    public static void main(String[] args) {

        AA aa = new AA();
        aa.calculateTime();
    }

    abstract public static class Template {

        public abstract void job();

        public void calculateTime() {
            long timeStart = System.currentTimeMillis();
            job();
            long timeEnd = System.currentTimeMillis();
            System.out.println("AA执行时间" + (timeEnd - timeStart));
        }
    }
}
class AA extends TestTemplate.Template {

    //计算任务
    public void job() {
        long sum = 0;
        for (long i = 0; i < 6000000; i++) {
            sum += i;
        }
    }
}
class BB extends TestTemplate.Template {

    public void job() {
        long sum = 0;
        for (long i = 0; i < 1000000; i++) {
            sum *= i;
        }
    }
}
