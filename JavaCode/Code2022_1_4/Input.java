import java.util.Scanner;//表示将java.util中的Scanner类导入

public class Input{
	public static void main(String[] args){
		//演示接收用户的输入
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入姓名");
		String name = myScanner.next();
		System.out.println("请输入年龄");
		int age = myScanner.nextInt();
		System.out.println("请输入薪水");
		double sal = myScanner.nextDouble();

		System.out.println("人的信息如下：");
		System.out.println("name = " + name + "\n" + "age = " + age + "\n" + "sal = " + sal);
	}
}