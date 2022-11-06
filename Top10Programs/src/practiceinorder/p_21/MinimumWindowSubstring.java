package practiceinorder.p_21;

import java.util.HashMap;

/*
	https://leetcode.com/problems/minimum-window-substring/
	https://www.youtube.com/watch?v=nMaKzLWceFg&t=52s
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String t="ABC";
		String s="AAABC";
		System.out.println(minWindow(s,t));

	}

	public static  String minWindow(String s, String t) {

		if (s.length() == 0 || s.length() < t.length())
			return "";

		// String t = "ABC"
		HashMap<Character, Integer> map = new HashMap();

		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int count = 0;
		int start = 0;
		int minlength = Integer.MAX_VALUE;
		int minleft = 0;

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
				if (map.get(s.charAt(i)) >= 0) {
					count++;
				}
			}

			while (count == t.length()) {// eliglble window

				// length save
				if (minlength > i - start + 1) {
					minlength = i - start + 1; // 6
					minleft = start;
				}
				// remove
				if (map.containsKey(s.charAt(start))) {
					map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
					if (map.get(s.charAt(start)) > 0) {
						count--;
					}
				}
				start++;
			}
		}
		if (minlength > s.length())
			return "";
		return s.substring(minleft, minleft + minlength);

	}

}
