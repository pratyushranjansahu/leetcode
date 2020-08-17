package eightyonetoninety;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int longestPalindrome(String s) {
		int result = 0;
		Map<Character, Integer> counts = new HashMap<>();
		for (char c : s.toCharArray())
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		boolean oddFound = false;
		for (int c : counts.values()) {
			if (c % 2 == 0)
				result += c;
			else {
				oddFound = true;
				result += c - 1;
			}

		}
		if (oddFound)
			result++;

		return result;
	}

}
