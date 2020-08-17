package seventyonetoeighty;

public class ArrangingCoins {

	public static void main(String[] args) {
		int n=5;
		System.out.println(arrangeCoins(n));

	}

	private static int arrangeCoins(int n) {
		long k = (long) Math.sqrt(2 * (long) n);
		long sum = k * (k + 1) / 2;
		if (sum > n)
			return (int) k - 1;
		return (int) k;
	}

}
