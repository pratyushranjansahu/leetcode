//https://www.youtube.com/watch?v=dTVX6nXQ2Ww
public class CaesarCipher {

	public static void main(String[] args) {
		String s = "middle-Outz";
		int k = 2;
		System.out.println(caesarCipher(s, k));

	}

	public static String caesarCipher(String s, int k) {
		String res = "";
		k = k % 26;
		for (char ch : s.toCharArray()) {
			if (!Character.isAlphabetic(ch)) {
				res += ch;
			} else {
				char en = (char) (ch + k);
				if (Character.isUpperCase(ch) && en > 90) {
					en = (char) (en - 26);
				} else if (Character.isLowerCase(ch) && en > 122) {
					en = (char) (en - 26);
				}
				res += en;
			}
		}
		return res;
	}

}
