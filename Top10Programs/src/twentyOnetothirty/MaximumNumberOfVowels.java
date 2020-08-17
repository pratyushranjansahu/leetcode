package twentyOnetothirty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumNumberOfVowels {
	public static void main(String[] args) {
		String s = "leeitcode";
		int k = 3;
		System.out.println(maxVowels(s, k));
	}

	private static int maxVowels(String s, int k) {
		List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
		Set<Character> vowels = new HashSet<>(list);
		int vCount = 0;
		for (int i = 0; i < k; i++)
			if (vowels.contains(s.charAt(i)))
				vCount++;
		int mVcount = vCount;
		int l=0,r=k-1;
		while(r<s.length()-1) {
			if(vowels.contains(s.charAt(l)))
				vCount--;
			l++;
			r++;
			if(vowels.contains(s.charAt(r)))
				vCount++;
			if(mVcount<vCount) {
				mVcount=vCount;
			}
		}
		return mVcount;
	}
}
