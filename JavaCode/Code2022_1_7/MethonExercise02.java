public class MethonExercise02 {

	public static void main(String[] args) {

		Print pf = new Print();
		pf.PrintChar(7, 7, '*');
	}
}

class Print {

	public void PrintChar(int row, int col, char ch) {
		int i = 0;
		for (i = 0; i < row; i++) {
			int j = 0;
			for (j = 0; j < col; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}