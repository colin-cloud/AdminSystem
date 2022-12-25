
public class Recursion02 {

	public static void main(String[] args) {

		//求出斐波那契数
		//1. 递归实现
		Object object = new Object();
		int num1 = object.fibonacci01(4);
		System.out.println(num1);
		int num2 = object.fabonacci02(4);
		System.out.println(num2);
	}
}

class Object {

	public int fibonacci01(int num) {
		if (num == 1 || num == 2) {
			return 1;
		} else {
			return fibonacci01(num - 1) + fibonacci01(num - 2);
		}
	}
	public int fabonacci02(int num) {
		int num1 = 1;
		int num2 = 1;
		int num3 = num1 + num2;
		if (num == 1 || num == 2) {
			return num1;
		} else {
			while (num - 2 != 0) {
				num3 = num1 + num2;
				num1 = num2;
				num2 = num3;
				num--;
			}
			return num3;
		}
	}

}