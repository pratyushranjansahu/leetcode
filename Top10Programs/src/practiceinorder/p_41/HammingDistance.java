package practiceinorder.p_41;

public class HammingDistance {

	public static void main(String[] args) {
		int x = 3;
		int y = 1;
		System.out.println(calculateDistance(x, y));

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
