package practiceinorder.p_161;
/*
	https://leetcode.com/problems/length-of-last-word/
	https://www.youtube.com/watch?v=E8r1N8wNR0A&t=156s
 */
public class LastWordLength {

	public static void main(String[] args) {
		String s="Hello123 world 123";
		System.out.println(lengthOfLastWord(s));

	}

	public static int lengthOfLastWord(String s) {
		int n = s.length(), result = 0;
		while(n > 0){
			if(s.charAt(--n) != ' ') result++;
			else if(result > 0) return result;
		}
		return result;
	}

}
