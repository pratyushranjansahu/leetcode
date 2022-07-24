package patterns.heaps;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
/*
	https://leetcode.com/problems/sort-characters-by-frequency/submissions/
	https://www.youtube.com/watch?v=eaGJh4v-wy4&t=1044s
	https://github.com/caomingkai/Leetcode/blob/master/451.%20Sort%20Characters%20By%20Frequency.java
 */
public class SortByFrequency {

	public static void main(String[] args) {
		String s = "tree";
		System.out.println(sortByFrequencyQueue(s));//eert
	}

	private static String sortByFrequency(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		Map<Character,Integer> counts=new HashMap<>();
		for(char c : s.toCharArray())
			counts.put(c, counts.getOrDefault(c, 0)+1);

		for(Map.Entry<Character, Integer> entries : counts.entrySet()) {
			for (int i = 0; i < entries.getValue(); i++) {
				stringBuilder.append(entries.getKey());
			}
		}

		return stringBuilder.toString();
	}
	private static String sortByFrequencyQueue(String s) {
		StringBuilder res = new StringBuilder();
		// edge case
		if( s == null || s.length() == 0 )
			return res.toString();

		// general case
		// get the frequence of each character
		Map<Character, Integer> map = new HashMap<>();  //  frequently used front half of 256
		int l = s.length();
		for( int i = 0; i < l; i++ ){
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c,0) + 1 ) ;
		}


		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>( new PQcomparator() );
		pq.addAll( map.entrySet() );

		while( pq.size() > 0 ){
			Map.Entry<Character, Integer> en = pq.poll();
			char c = en.getKey();
			int  f = en.getValue();
			for( int i = 0; i < f; i++ ){
				res.append(c);
			}
		}
		return res.toString();

	}
	private static class PQcomparator implements Comparator<Map.Entry<Character, Integer>>{
		@Override
		public int compare( Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2 ){
			return e2.getValue() - e1.getValue();
		}
	}
}
