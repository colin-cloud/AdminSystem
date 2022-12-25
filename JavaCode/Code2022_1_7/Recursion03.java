

public class Recursion03 {

	public static void main(String[] args) {

		Recursion rec = new Recursion();
		System.out.println(rec.monkeyEatPeach(1));
	}
}

class Recursion {
	//返回的是最初的桃子数
	public int monkeyEatPeach(int day) {
		if (day == 10) {
			return 1;
		} else if (day >= 1 && day <= 9){
			return (monkeyEatPeach(day + 1) + 1) * 2;
		} else {
			System.out.println("输入错误");
			return 0;
		}
	}
}