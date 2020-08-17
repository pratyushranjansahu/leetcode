package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));

	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		// List<List<String>> result=new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String word : strs) {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if (map.containsKey(key)) {
				List<String> l = map.get(key);
				l.add(word);
				map.put(key, l);
			} else {
				List<String> list = new ArrayList<>();
				list.add(word);
				map.put(key, list);

			}

		}
		return new ArrayList<>(map.values());
	}

}
