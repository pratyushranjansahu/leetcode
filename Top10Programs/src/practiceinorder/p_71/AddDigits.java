package practiceinorder.p_71;

public class AddDigits {

	public static void main(String[] args) {
		int n=123;
		addDigits(n);

	}
	
	private static int addDigits(int n) {
		if(n==0) return 0;
		if(n%9==0) return 9;
		return n%9;
	}

}
