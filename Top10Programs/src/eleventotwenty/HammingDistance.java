package eleventotwenty;

public class HammingDistance {

	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		calculateDistance(x, y);

	}

	private static int calculateDistance(int x, int y) {
		int count = 0;
		int res = x ^ y;
		while (res > 0) {
			count += (res & 1);
			res >>= 1;
		}

		return count;
	}

}
