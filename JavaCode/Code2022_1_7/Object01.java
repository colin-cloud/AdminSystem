
//每个方法执行的过程中都会产生对应的一个栈
//防止执行完毕后对应的栈区就会被释放

public class Object01 {

	public static void main(String[] args) {
		//创建对象
		Person one = new Person();
		//赋值
		one.name = "王先生";
		one.age = 18;
		//在创建一个对象
		Person two = new Person();
		two.name = "夏律师";
		two.age = 40;
		//调用方法-通过自己创建的对象进行调用
		int sumAge = one.getSum(one.age, two.age);
		//方法调用完了之后getSum栈销毁
		System.out.println(sumAge);
	}
}

//创建一个类
class Person {
	//类的属性信息
	String name;
	int age;
	//类的方法信息
	public int getSum(int n, int m) {
		return n + m;
	}
}