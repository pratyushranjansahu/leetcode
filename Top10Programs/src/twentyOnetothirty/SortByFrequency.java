package twentyOnetothirty;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortByFrequency {

	public static void main(String[] args) {
		String s = "tree";
		System.out.println(sortByFrequency(s));
	}

	private static String sortByFrequency(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		Map<Character,Integer> counts=new HashMap<>();
		for(char c : s.toCharArray())
			counts.put(c, counts.getOrDefault(c, 0)+1);
		
		counts=counts.entrySet()
		.stream()
		.sorted(comparingByValue(Comparator.reverseOrder()))
		.collect(toMap(Map.Entry<Character, Integer> :: getKey, Map.Entry<Character, Integer> :: getValue,(e1,e2)-> e1,LinkedHashMap :: new));
		
		for(Map.Entry<Character, Integer> entries : counts.entrySet()) {
			for (int i = 0; i < entries.getValue(); i++) {
				stringBuilder.append(entries.getKey());
			}
		}
		
		
		return stringBuilder.toString();

	}

}
