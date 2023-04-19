package practiceinorder.p_81;
/*
	https://leetcode.com/problems/reverse-bits/description/
	https://www.youtube.com/watch?v=LJiMk8lPJNc&t=303s
 */
public class ReverseBits {

	public static void main(String[] args) {
		int n = 5;
		reverseBits(n);
	}

	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i ++) {
			int lsb = n & 1;
			int reverseLsb = lsb << (31 - i);
			result = result | reverseLsb;
			n = n >> 1;
		}
		return result;
	}

}
