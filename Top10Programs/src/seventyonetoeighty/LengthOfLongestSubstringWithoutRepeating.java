package seventyonetoeighty;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstringWithoutRepeating {

	public static void main(String[] args) {
		String s="abccba";
		System.out.println(maxSubstringlength(s));

	}
	
	private static int maxSubstringlength(String s) {
		int maxCount=0;
		int i=0,j=0;
		Set<Character> set=new HashSet<>();
		while(i<s.length() && j<s.length()) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				maxCount=Math.max(maxCount, j-i);
			}else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return maxCount;
	}

}
