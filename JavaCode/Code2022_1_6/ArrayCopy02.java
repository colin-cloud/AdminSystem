public class ArrayCopy02 {

	public static void main(String[] args) {
		
		int[] arr = {11, 22, 33, 44, 55, 66};
		
		int[] reverseArr = new int[arr.length];
		int i = 0;
		int j = 0;
		//1. 创建逆序拷贝数组
		for (i = arr.length - 1, j = 0; i >= 0; i--, j++) {
			reverseArr[j] = arr[i];
		}
		arr = reverseArr;
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		//2. 创建临时变量
		for (i = 0; i < arr.length; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1];
			arr[arr.length - 1] = temp;
		}
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}