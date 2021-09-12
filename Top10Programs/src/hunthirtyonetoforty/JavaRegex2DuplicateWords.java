//https://www.youtube.com/watch?v=OUT0SZ6j0TQ
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex2DuplicateWords {

	public static void main(String[] args) {
		// String input="Goodbye bye bye world world world";
		String input = "Reya is is the the best player in eye eye game";
		removeDuplicate(input);
	}

	private static void removeDuplicate(String input) {
		String regex = "(\\b\\w+)(\\s\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);

		// Check for subsequences of input that match the compiled pattern
		while (m.find()) {
			input = input.replaceAll(m.group(), m.group(1));
		}

		// Prints the modified sentence.
		System.out.println(input);
	}

}
