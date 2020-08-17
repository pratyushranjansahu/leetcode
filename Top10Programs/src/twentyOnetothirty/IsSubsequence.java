package twentyOnetothirty;

public class IsSubsequence {

	public static void main(String[] args) {
		String s="abc";
		String t="akjhkdjfbklkfjdsc";
		System.out.println(isSubsequence(s, t));

	}

	private static boolean isSubsequence(String s, String t) {
		if(s.length()==0) return true;
		int sIdx = 0;
		for (int i = 0; i < t.length(); i++) {
			if(s.charAt(sIdx)==t.charAt(i))
				sIdx++;
			if(sIdx==s.length())
				return true;
		}
		
		return sIdx==s.length();
	}

}
