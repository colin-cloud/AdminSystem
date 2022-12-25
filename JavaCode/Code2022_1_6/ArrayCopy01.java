import java.util.*;

public class ArrayCopy01 {

	public static void main(String[] args) {
			int i = 0;
			int[] array = new int[10];
			for (i = 0; i < array.length; i++) {
			
				array[i] = i;
				System.out.print(array[i] + " ");
			}
			System.out.println();
			int[] array1 =Arrays.copyOf(array, array.length);
			for (i = 0; i < array1.length; i++) {

				System.out.print(array1[i] + " ");
			}
			
			System.out.println();
			int left = 0;
			int right = array1.length - 1;
			while(left < right) {
				int tmp = array1[left];
				array1[left] = array1[right];
				array1[right] = tmp;
				left++;
				right--;
			}
			// for (i = 0; i < array1.length; i++) {
			// 	System.out.print(array1[i] + " ");
			// }
			System.out.println();
			array = Arrays.copyOf(array1, array1.length);
			for (i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}

			// System.out.println();
			// array = Arrays.copyOf(array, array.length * 2);
			// for (i = 0; i < array.length; i++) {
			// 	System.out.print(array[i] + " ");
			// }
	}
}