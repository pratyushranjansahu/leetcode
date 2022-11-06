package twentyOnetothirty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
	static Map<String, List<String>> dp = new HashMap<>();

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");

		System.out.println(wordBreak(s, wordDict));

	}

	private static List<String> wordBreak(String s, List<String> wordDict) {
		if (dp.containsKey(s))
			return dp.get(s);
		List<String> result = new ArrayList<>();
		for (String w : wordDict) {
			if (w.length() <= s.length()) {
				if (s.substring(0, w.length()).equals(w)) {
					if (w.length() == s.length()) {
						// System.out.println(w);
						result.add(w);
					} else {
						List<String> tmp = wordBreak(s.substring(w.length()), wordDict);
						for (String t : tmp)
							result.add(w + " " + t);
						// result.add(w+t);
					}
				}
			}
		}
		dp.put(s, result);
		return result;
	}


}
