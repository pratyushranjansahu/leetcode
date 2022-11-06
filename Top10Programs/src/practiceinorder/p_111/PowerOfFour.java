package practiceinorder.p_111;

public class PowerOfFour {

	public static void main(String[] args) {
		int n=46;
		System.out.println(isPowerOfFour(n));

	}
	
	private static boolean isPowerOfFour(int n) {
		return ((n & (n-1))==0  && n %3==1);
	} 

}
