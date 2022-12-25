public class ArrayAdd {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3};
		int[] arrNew = new int[arr.length + 1];
		int i = 0; 
		for (i = 0; i < arr.length; i++)  {

			arrNew[i] = arr[i];
		}
		arrNew[i] = 4;
		arr = arrNew;
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}