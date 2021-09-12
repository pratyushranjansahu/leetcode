//https://www.youtube.com/watch?v=rPRsseF6Qi4
public class JavaRegex {

	public static void main(String[] args) {
		// String IP="000.12.12.034";
		String IP = "Hello.IP";
		System.out.println(isValidIP(IP));

	}

	private static boolean isValidIP(String IP) {
		String number = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
		String pattern = number + "." + number + "." + number + "." + number;
		return IP.matches(pattern);
	}

}
