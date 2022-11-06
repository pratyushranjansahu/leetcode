package practiceinorder.p_111;

public class PowerOfTwo {

	public static void main(String[] args) {
		int n=8;
		System.out.println(isPowerOfTwo(n));

	}
	private static boolean isPowerOfTwo(int n) {
		return n>0 && (n&(n-1))==0;
	}

}
