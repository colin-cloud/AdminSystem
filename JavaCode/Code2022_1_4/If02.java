
import java.util.Scanner;

public class If02{

	public static void main(String[] args){

		//判断初赛成绩
		Scanner myScanner = new Scanner(System.in);
		double score = myScanner.nextDouble();
		char sex = myScanner.next().charAt(0);//接收字符

		//判断性别
		if (sex == '男'){
			if (score > 8.0){
				System.out.println("恭喜你进入决赛！");
			}
			else{
				System.out.println("失败！");
			}
		}
		else{
			if (score > 8.0){
				System.out.println("恭喜你进入决赛!");
			}
			else{
				System.out.println("失败！");
			}
		}
	}
}
