

public class VarParameter01 {

	public static void main(String[] args) {

		Methods tools = new Methods();
		System.out.println(tools.sum(1, 2, 3, 5));
		//可变参数的实参可以是数组
		int arr[] = {1, 2, 3};
		System.out.println(tools.sum(arr));
		//可变参数可以和普通类型的参数一起放在参数列表，但必须放在最后
		//一个形参列表只能存在一个可变参数
	}
}

class Methods {

	public int sum(int n1, int n2) {
		return n1 + n2;
	}
	//可变参数案例
	public int sum(int... nums) {
		int i = 0;
		int res = 0;
		for (i = 0; i < nums.length; i++) {
			res += nums[i];
		}
		return res;
	}
	//error
	// public void m(int... nums, double... numss) {
	// 	//
	// }
}