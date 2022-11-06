package practiceinorder.p_81;

public class ReverseBits {

	public static void main(String[] args) {
		int n = 5;
		reverseBits(n);
	}

	private static int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res <<= 1;
			if ((n & 1) > 0)
				res++;
			n >>= 1;
		}
		return res;
	}

}
