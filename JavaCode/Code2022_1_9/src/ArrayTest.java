import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = 10 - i;
        }
        Scanner myScanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);//快速命名 .var
        //new Scanner(System.in).var;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        MyTools tools = new MyTools();
        tools.bubbleSort(array);//快速定位方法位置 Ctrl + b
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
//创建一个类MyTools，编写一个方法，可以完成对int数组冒泡排序的功能

class MyTools {

    public void bubbleSort(int[] array) {
        int i = 0;
        int j = 0;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
//查看类的继承 - Ctrl + h

class Person {
    String name;
    int age;

//构造器的创建 - 快捷键 Alt + insert
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}