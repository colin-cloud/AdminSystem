import java.util.Scanner;

public class BreakExercise {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		final String name = "丁真";
		final String key = "666";
		int i = 0;
		for (i = 0; i < 3; i++) {

			System.out.print("请输入同户名:>");
			String administrationName = myScanner.next();
			System.out.print("请输入密码:>");
			String keyword = myScanner.next();
			//比较字符串
			//方法：equals
			if (name.equals(administrationName) && key.equals(keyword)){
				System.out.println("输入正确");
				break;
			} 
			else{
				System.out.println("输入错误，请重新输入");
			}
		}
	}
}