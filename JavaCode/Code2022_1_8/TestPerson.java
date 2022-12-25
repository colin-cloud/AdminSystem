

public class TestPerson {

	public static void main(String[] args) {


	}
}

class Person {

	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean compareTo(Person per) {
		return this.name.equals(per.name) && this.age == per.age;
	}
}