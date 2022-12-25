import java.util.Arrays;

public class BubbleSort01 {

	public static void main(String[] args) {

		//实现冒泡排序从小到大
			
		int[] array = {1, 2, 3, 4, 7, 6 ,9, 10, 22, 34};

		int i = 0;
		int j = 0;
		//确定躺数
		for (i = 0; i < array.length - 1; i++) {

			//确定一趟进行比较的次数
			for (j = 0; j < array.length - 1 - i; j++) {

				//实现将大数转移至最后
				if (array[j] > array[j + 1]) {
					//交换
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		
		int i = 0;
		Arrays.sort(array);
		//输出
		for (i = 0; i < array.length; i++) { 
			System.out.print(array[i] + " ");
		}

	}
}