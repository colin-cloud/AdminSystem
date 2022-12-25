
import java.util.Scanner;

public class If01{
	public static void main(String[] args){
		//判断一个年份是否为闰年
		//1. 能被4整除但不能被100整除
		//2. 能被400整除
		//输入一个年份
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("请输入年份:");

		int year = myScanner.nextInt();

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			System.out.println(year + "是闰年！");
		}
		else{
			System.out.println(year + "不是闰年！");
		}
	}
}