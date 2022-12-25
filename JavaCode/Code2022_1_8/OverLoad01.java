

public class OverLoad01 {

	public static void main(String[] args) {

		Methods tools = new Methods();
		tools.m(1);
		tools.m(1, 2);
		tools.m("Ğ¡°×Ñ§±à³Ì");
		int num1 = tools.max(2, 1);
		double num2 = tools.max(1.1, 2.2);
		double num3 = tools.max(1.2, 2.2, 3.2);
		System.out.println(num1 + " " + num2 + " " + num3); 	 	
	}
}

class Methods {

	public void m(int num) {
		int pow = num * num;
		System.out.println(pow);
	}
	public void m(int num1, int num2) {
		int tmp = num1 * num2;
		System.out.println(tmp);
	}
	public void m(String str) {
		System.out.println(str);
	}

	public int max(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}
	public double max(double num1, double num2) {
		return num1 > num2 ? num1 : num2;
	}
	public double max(double num1, double num2, double num3) {
		double num = num1 > num2 ? num1 : num2;
		return num3 > num ? num3 : num;
	}
}