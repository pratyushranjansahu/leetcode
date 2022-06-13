package patterns.slidingwindow;
/*
	https://leetcode.com/problems/permutation-in-string/
	https://www.youtube.com/watch?v=EVoBXXOMnLI&t=66s
 */
public class PermutationInString {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abf";
		System.out.println(findAnagrams(s, p));

	}
	private static boolean findAnagrams(String s, String p) {
		//List<Integer> result = new ArrayList();
		 if(p.length()>s.length()) return false;
		int[] pchar = new int[26];
		for (char c : p.toCharArray())
			pchar[c - 'a'] += 1;
		for (int i = 0; i < p.length(); i++) {
			pchar[s.charAt(i) - 'a'] -= 1;
		}
		int start = 0;
		int misMatchCount = 0;
		for (int pc : pchar)
			if (pc != 0)
				misMatchCount++;
		if (misMatchCount == 0)
			return true;
		start++;
		while (start <= s.length() - p.length()) {
			int idx1 = s.charAt(start - 1) - 'a';
			int idx2 = s.charAt(start + p.length() - 1) - 'a';
			pchar[idx1] += 1;
			if (pchar[idx1] == 1)
				misMatchCount++;
			else if (pchar[idx1] == 0)
				misMatchCount--;
			pchar[idx2] -= 1;
			if (pchar[idx2] == -1)
				misMatchCount++;
			else if (pchar[idx2] == 0)
				misMatchCount--;

			if (misMatchCount == 0)
				return true;
			start++;
		}

		return false;
	}
}
