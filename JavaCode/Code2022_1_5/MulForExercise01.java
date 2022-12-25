import java.util.Scanner;

public class MulForExercise01{

	public static void main(String[] args){

		//写一个自己的扫描器
		Scanner myScanner = new Scanner(System.in);

		//定义变量
		double classOneScore = 0.0;
		double classTwoScore = 0.0;
		double classThreeScore = 0.0;
		double studentScore = 0.0;
		int i = 0;
		int j = 0;
		for (i = 0; i < 3; i++){
			System.out.println("请输入班级同学的分数:>");
			for (j = 0; j < 5; j++){
				System.out.println("请输入" + i + "班级" + j + "同学的分数:>");
				studentScore = myScanner.nextDouble();
				if (i == 0){
					classOneScore += studentScore; 
				}
				if (i == 1){
					classTwoScore += studentScore;
				}
				if (i == 2){
					classThreeScore += studentScore;
				}
			}
		}
		System.out.println("一班的平均分为:" + classOneScore / 5);
		System.out.println("二班的平均分为:" + classTwoScore / 5);
		System.out.println("三班的平均分为:" + classThreeScore / 5);
		System.out.println("所有班级的平均分为:" + 
			(classOneScore + classTwoScore + classThreeScore) / 15);
		
		//统计三个班级及格人数，每个班有5名同学
		//
		//打印乘法表
		// int row = 0;
		// int col = 0;
		// for (row = 0; row < 9; row++){
		// 	//打印行
		// 	for (col = 0; col <= row; col++){
		// 		//打印列
		// 		System.out.print((row + 1) + " * " + (col + 1) + "= " + ((row + 1) * (col + 1)) 
		// 							+ " " );
		// 	}
		// 	//换行
		// 	System.out.print("\n");
		// }
	}
}