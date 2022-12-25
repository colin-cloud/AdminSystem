public class MethodExercise01 {

	public static void main(String[] args) {
		int[][] array = new int[2][2];
		Person person = new Person();
		person.name = "王先生";
		person.age = 10;
		MyTools tools = new MyTools();
		//tools.PrintTwoDimensionalArray(array);
		Person copyPerson = tools.copyPerson(person);
		System.out.println("克隆对象信息如下:");
		System.out.println("姓名为" + copyPerson.name + " " + "年龄为" + copyPerson.age);
	}
}

class Person {
	String name;
	int age;
}

class MyTools {

	public void PrintTwoDimensionalArray(int[][] array) {
		int i = 0;
		for (i = 0; i < array.length; i++) {
			int j = 0;
			for (j = 0; j <array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
	}

	public Person copyPerson(Person person) {
		Person copyPer = new Person();
		copyPer.name = person.name;
		copyPer.age = person.age;
		return copyPer;
	}
}