//https://www.youtube.com/watch?v=a46eKP6mL1A
import java.util.regex.Pattern;

public class PatternSyntaxChecker {

	public static void main(String[] args) {
		// String pattern="([A-Z])(.+)";
		String pattern = "batcatpat(nat";
		checkPattern(pattern);
	}

	private static void checkPattern(String pattern) {
		try {
			Pattern.compile(pattern);
			System.out.println("Valid");
		} catch (Exception e) {
			System.out.println("Invalid");
		}
	}

}
