import java.util.Scanner;

public class SeqSearch {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		String[] array = {"青眼白龙", "金毛狮王", "白眉鹰王"};
		System.out.print("请输入想要查找的名称:>");
		String findName = myScanner.next();
		//定义标识符
		int index = -1;//用来查看是否找得到
		int i = 0;
		for (i = 0; i < array.length; i++) {
			if (findName.equals(array[i])) {
				System.out.println("找到了,下标为" + i);
				index = 1;
				break;
			}
		}
		//标识符是否改变
		if (index == -1) {
			System.out.println("找不到");
		}
	}
}