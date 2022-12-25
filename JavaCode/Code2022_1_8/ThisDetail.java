public class ThisDetail {

	public static void main(String[] args) {


	}
}

class this {

	public void fn1() {

	}
	public void fn2() {
		this.fn1();
	}
}