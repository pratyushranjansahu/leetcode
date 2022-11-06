package practiceinorder.p_51;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String text1 = "abc";
		String text2 = "agbc";

		System.out.println("Longest Common SubSequence is : " + getSubSequence(text1, text2));
		
	}

	private static int getSubSequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] lcs = new int[m+1][n+1];
		StringBuilder sb1=new StringBuilder();
		for (int i = 1; i <=m; i++) {
			for (int j = 1; j <=n; j++) {
				if(text1.charAt(i-1)==text2.charAt(j-1)) {
					lcs[i][j]=1+lcs[i-1][j-1];
				//	sb1.append(text1.charAt(i-1));
				}else {
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		
		StringBuilder sb=new StringBuilder();
		int i=m;int j=n;
		while(i>0 && j>0) {
			if(text1.charAt(i-1)==text2.charAt(j-1)) {
				sb.append(text1.charAt(i-1));
				i--;j--;
			}else if(lcs[i-1][j]>lcs[i][j-1]){
				i--;
			}else {
				j--;
			}
		}
		
		System.out.println(sb1);
		return lcs[m][n];
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] lcs = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		int i = m, j = n;
		while (i > 0 && j > 0) {

			if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
				stringBuilder.append(text1.charAt(i - 1));
				// LCS[index-1] = s1[i-1]; // Put current character in result
				i--;
				j--; // index--; // reduce values of i, j and index
			}
			// compare values of L[i-1][j] and L[i][j-1] and go in direction of greater
			// value.
			else if (lcs[i - 1][j] > lcs[i][j - 1])
				i--;
			else
				j--;
		}

		System.out.println(" LongestCommon Subsequence is : " + stringBuilder.reverse().toString());

		return lcs[m][n];
	}
	


}
