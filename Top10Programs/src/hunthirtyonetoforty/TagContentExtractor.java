//https://www.youtube.com/watch?v=jjASqBQDa4s
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

	public static void main(String[] args) {
		String line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>";
		printContent(line);
	}

	private static void printContent(String line) {
		// Write your code here
		boolean hasMatch = false;
		Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
		Matcher match = p.matcher(line);
		while (match.find()) {
			System.out.println(match.group(2));
			hasMatch = true;

		}
		if (!hasMatch)
			System.out.println("None");
	}

}
