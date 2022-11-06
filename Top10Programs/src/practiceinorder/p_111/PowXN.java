package practiceinorder.p_111;

public class PowXN {

	public static void main(String[] args) {
		int x = 2;
		int n = 3;
		System.out.println(myPower(x, n));

	}

	private static double myPower(int x, int n) {
		return power_util(x, n);
	}

	private static double power_util(int x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n < 0)
			return power_util(1 / x, -n);
		double result = power_util(x * x, n / 2);
		if (n % 2 == 1)
			result *= x;
		return result;
	}

}
