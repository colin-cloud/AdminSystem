import java.util.Scanner;

public class PhoneContactSystem {

	public static void main(String[] args) {
		  
		MyTools myTools = new MyTools();
		Scanner myScanner = new Scanner(System.in);
		int input = 0;
		int contactSize = 0;
		System.out.println("请输入想要创建的通信录的大小:>");
		contactSize = myScanner.nextInt();
		Contact con = new Contact();
		do {
			myTools.menu();
			System.out.print("");
			
			input = myScanner.nextInt();
			switch(input) {
				case 1:
					myTools.addContactMember(con);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 0:
					System.out.println("");
					break;
				default:
					System.out.println("");
					break;
			}	
		} while(input != 0);
		
	}
}

class PersonInfomation {
	String name;
	int age;
	String phoneNumber;
	String address;
}

class Contact {
	PersonInfomation[] data;
	int sz;
}

class MyTools {

	Scanner myScanner = new Scanner(System.in);
	public void menu() {
		System.out.println("*********************************");
		System.out.println("********   1. Add   *************");
		System.out.println("********   2. Delete   **********");
		System.out.println("********   3. Search   **********");
		System.out.println("********   4. Modify   **********");
		System.out.println("********   0. Exit     **********");
		System.out.println("*********************************");
	}
	//对通信录进行创建和初始化
	public void initialContact(Contact con) {
		con.data = new PersonInfomation[contactSize];
		for (int i = 0; i < contactSize; i++) {
			con.data[i] = new PersonInfomation();
		}
	}
	public void addContactMember(Contact con) {
		System.out.print("请输入姓名:>");
		con.data[con.sz].name = myScanner.next();
		System.out.print("请输入年龄:>");
		con.data[con.sz].age = myScanner.nextInt();
		System.out.println("添加成功");
		con.sz++;
	}
	public void printContactPersonInfomaintion(Contact con) {
		System.out.println(con.data[0].name);
	}
}
