package practiceinorder.p_51;

public class LongestPalindromicSubstring {
	static int start = 0;
	static int end = 0;
	static int max_len = 1;
	static int n = 0;

	public static void main(String[] args) {
		String s = "an";
		n = s.length();
		System.out.println(palindrom(s));

	}

	private static String palindrom(String s) {
		n = s.length();
		if (s.length() <= 1)
			return s;
		for (int i = 0; i < n - 1; i++) {
			// for odd length
			getSubString(i, i, s);
			// for even length
			getSubString(i, i + 1, s);
		}
		return s.substring(start, end + 1);
	}

	private static void getSubString(int l, int r, String s) {
		while (l >= 0 && r < n) {
			if (s.charAt(l) == s.charAt(r)) {
				l--;
				r++;
			} else {
				break;
			}
		}
		int len = r - l - 1;
		if (len > max_len) {
			max_len = len;
			start = l + 1;
			end = r - 1;
		}
	}
}
