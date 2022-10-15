package hundreadtwintyonetothirty;
/*
	https://www.interviewbit.com/problems/maximum-sum-square-submatrix/
	https://www.youtube.com/watch?v=WxjYE4_agbo
 */
public class MaximumSumSquareSubMatrix {

	public static void main(String[] args) {
		int[][] A = {{2,4,5},{1,3,6},{1,5,5}};
		int B = 2;
		System.out.println(solve(A,B));
	}

	public static int solve(int[][] A, int B) {

		int row = A.length;
		int col = A[0].length;
		int maxsum = Integer.MIN_VALUE;
		int[][] dp = new int[row + 1][col + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = A[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// 3X3
				int sum = Integer.MIN_VALUE;
				if (i - B >= 0 && j - B >= 0) {
					sum = dp[i][j] - dp[i - B][j] - dp[i][j - B] + dp[i - B][j - B];
					maxsum = Math.max(sum, maxsum);
				}
			}
		}
		return maxsum;
	}

}
