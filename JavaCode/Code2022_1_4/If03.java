

//演示多分支代码
import java.util.Scanner;

public class If03{

	public static void main(String[] args){

		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("请输入芝麻信用分:");

		int creditScore = myScanner.nextInt();

		if (creditScore <= 100)
		if (creditScore == 100)
			System.out.println("信用极好!");
		else if (creditScore > 80 && creditScore <= 90)
			System.out.println("信用优秀!");
		else if (creditScore >= 60 && creditScore <= 80)
			System.out.println("信用一般!");
		else
			System.out.println("信用不及格!");
		else
			System.out.println("输入错误");
	}

}