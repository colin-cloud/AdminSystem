
//二维数组的列数可以不相同
//实例：

public class TwoDimensionalArray01 {

	public static void main(String[] args) {
		
		int[][] array;
		array = new int[3][];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			//为每一行开辟相应列数的空间
			array[i] = new int[i + 1];
			int len = 0;
			for (len = 0; len < array[i].length; len++) {
				array[i][len] = i + 1;
			}
		}
		for (i = 0; i < array.length; i++) {
			int j = 0;
			for (j = 0; j < array[i].length; j++) {

				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}