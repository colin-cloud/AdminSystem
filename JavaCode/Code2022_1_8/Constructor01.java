

public class Constructor01 {

	public static void main(String[] args) {

		Person per = new Person("wang", 10);

		System.out.println("�˵���Ϣ����:");
		System.out.println(per.name + per.age);
	}
}

class Person {
	String name;
	int age;
	//��������������������ͬ��û�з�������
	//1. ����ʵ�ֹ�����������
	//2. �������ǶԶ���ĳ�ʼ�������Ǵ���
	public Person(String pName, int pAge) {

		name = pName;
		age = pAge;
	}
}

class Dog {


}