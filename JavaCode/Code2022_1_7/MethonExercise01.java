public class MethonExercise01 {

	public static void main(String[] args) {

		AA a = new AA();
		boolean m = a.isOddNum(1);
		if (m) {
			System.out.println("ÆæÊý");
		}
		else {
			System.out.println("Å¼Êý");
		}
	}
}
//
class AA {
	public boolean isOddNum(int num) {

		if (num % 2 == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}