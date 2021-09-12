//https://www.youtube.com/watch?v=wG_sFhuYcnA
public class TwoCharacters {
	public static void main(String[] args) {

		String s = "beabeefeab";

		int result = alternate(s);
		System.out.println(result);
	}

	public static int alternate(String s) {

		int n = s.length();
		if (n == 1)
			return 0;
		int[][] pair = new int[26][26];
		int[][] count = new int[26][26];

		for (int i = 0; i < n; i++) {
			char letter = s.charAt(i);
			int letterNum = letter - 'a';
			// Update Row

			for (int c = 0; c < 26; c++) {
				if (pair[letterNum][c] == letter) {
					count[letterNum][c] = -1;
				}

				if (count[letterNum][c] != -1) {
					pair[letterNum][c] = letter;
					count[letterNum][c]++;
				}
			}

			// Update Column
			for (int r = 0; r < 26; r++) {
				if (pair[r][letterNum] == letter) {
					count[r][letterNum] = -1;
				}

				if (count[r][letterNum] != -1) {
					pair[r][letterNum] = letter;
					count[r][letterNum]++;
				}
			}
		}
		int max = 0;
		for (int row = 0; row < 26; row++) {
			for (int col = 0; col < 26; col++) {
				max = Math.max(max, count[row][col]);
			}
		}
		return max;
	}
}
