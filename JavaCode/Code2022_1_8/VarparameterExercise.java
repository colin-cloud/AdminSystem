

public class VarParameterExercise {

	public static void main(String[] args) {

		//返回姓名和成绩总分
		MyTools tools =new MyTools();
		System.out.println(tools.showScore("小明", 1, 2, 3));
	}
}

class MyTools {

	public String showScore(String str, double... score) {
		double totalScore = 0;
		int i = 0;
		for (i = 0; i < score.length; i++) {
			totalScore += score[i];
		}
		return str + "的" + score.length + "门成绩总分为" + totalScore;
	}
}