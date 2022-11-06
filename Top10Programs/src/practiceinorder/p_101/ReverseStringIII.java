package practiceinorder.p_101;

public class ReverseStringIII {

	public static void main(String[] args) {
		String s="Let's do coding";
		System.out.println(reverse(s));

	}
	
	private static String reverse(String s) {
		StringBuilder sb=new StringBuilder();
		int l=0,r=0;
		while(l<s.length()) {
			while(r<s.length() && s.charAt(r)!=' ')
				r++;
			sb.append(reverseString(s.substring(l, r)));
			sb.append(" ");
			l=r+1;
			r=l;
		}
		System.out.println(sb);
		sb=sb.deleteCharAt(sb.length()-1);
		return sb.toString().trim();
	}
	
	private static String reverseString(String s) {
		StringBuilder sb=new StringBuilder(s);
		return sb.reverse().toString();
		
	}

}
