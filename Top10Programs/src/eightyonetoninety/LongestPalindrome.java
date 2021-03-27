package eightyonetoninety;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

	public static void main(String[] args) {
		String s="abbcacc";
		System.out.println(longestPalindrome1(s));

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
	
	private static String longestPalindrome1(String s) {
		int result = 0;
		char lastChar=' ';
		Map<Character, Integer> counts = new HashMap<>();
		for (char c : s.toCharArray())
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		boolean oddFound = false;
		StringBuilder sb=new StringBuilder();
		
		
		for (Map.Entry<Character,Integer> entry : counts.entrySet()) {
			int c=entry.getValue();
			if (c % 2 == 0) {
				result += c;
				concat(sb, entry.getKey(), c);
			}
			else {
				lastChar=entry.getKey();
				oddFound = true;
				result += c - 1;
			}
		}
		if (oddFound)
			sb.append(lastChar);
		
		return sb.toString();
	}
	
	private static  void concat(StringBuilder sb,char c,int n) {
		for (int i = 0; i < n; i++) {
			sb.append(c);
		}
	}

}
