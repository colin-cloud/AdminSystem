import java.util.Scanner;
public class Test {
	
	public static void main(String[] args) {
		Contact con = new Contact();
		con.data = new Person[30];
		con.data[0].name = null;
		con.sz = 0;
		Scanner myScanner = new Scanner(System.in);
		MyTools tool = new MyTools();
		tool.Add(con);
		System.out.println(con.data[0].name);
	}
}
class Contact {
	Person[] data;
	int sz;
}

class Person {
	String name;
}

class MyTools {
	Scanner myScanner = new Scanner(System.in);
	public void Add(Contact con) {
		System.out.println("«Î ‰»Î–’√˚");
		con.data[0].name = myScanner.next();
	}
}