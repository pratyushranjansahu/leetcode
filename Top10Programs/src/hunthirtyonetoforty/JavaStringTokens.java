//https://www.youtube.com/watch?v=nIWJ09eJdqs
public class JavaStringTokens {

	public static void main(String[] args) {
		String s="He is a very very good boy, isn't he?";
		getTokens(s);

	}

	private static void getTokens(String s) {
		s = s.trim();
		String[] sarr = s.split("[^a-zA-Z]+");
		if (s.length() == 0) {
			System.out.println(0);
		} else {
			System.out.println(sarr.length);
		}
		for (String string : sarr) {
			System.out.println(string);
		}
	}

}
