import java.util.Scanner;

public class If04{

	public static void main(String[] args){

		//实现出票系统
		Scanner myScanner = new Scanner(System.in);

		System.out.println("请输入季节:");
		char season = myScanner.next().charAt(0);
		System.out.println("请输入你的年龄:");
		int age = myScanner.nextInt();
		//判断旺季和淡季
		if (season == '旺'){
			if (age > 0){
				if (age > 60){
				System.out.println("票价为：20");
			}
			else if (age < 18){
				System.out.println("票价为：30");
			}
			else
				System.out.println("票价为：60");
			}
			else{
				System.out.println("输入错误的年龄");
			}
			
		}
		else if (season == '淡'){
			if (age > 0){
				if (age>= 18 && age <= 60){
				System.out.println("票价为：40");
			}
			else{
				System.out.println("票价为：20");
			}
			}
			else{
				System.out.println("输入错误的年龄");
			}
		}
		else{
			System.out.println("输入错误");
		}
	}
}