
public class ArrayExercise {

	public static void main(String[] args) {

		int[] array = {4, -1, 9, 10, 23};
		int indexMaxNumber = 0;
		int i = 0;
		for (i = 1; i < array.length; i++) {
			if (array[i] > array[indexMaxNumber]) {
				indexMaxNumber = i;
			}
		}
		System.out.println("数组最大值为:" + array[indexMaxNumber]);
		System.out.println("下标为:" + indexMaxNumber);
	}
}