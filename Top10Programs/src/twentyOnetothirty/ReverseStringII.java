package twentyOnetothirty;

public class ReverseStringII {

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		System.out.println(reverseString(s, k));

	}

	private static String reverseString(String s, int k) {
		StringBuilder stringBuilder = new StringBuilder();
		int l = 0;
		int r = Math.min(k, s.length());
		while (l < s.length()) {
			stringBuilder.append(reverse(s.substring(l, r)));
			l+=2*k;
			if(l>s.length())
				stringBuilder.append(s.substring(r));
			else
				stringBuilder.append(s.substring(r, l));
			r=Math.min(l+k, s.length());
		}

		return stringBuilder.toString();
	}

	private static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

}
