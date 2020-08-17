package seventyonetoeighty;

public class PerfectSquares {

	public static void main(String[] args) {
		int n = 13;
		System.out.println(numSquares(n));
	}

	private static int numSquares(int n) {
		int[] dp=new int[n+1];
		int minValue;
		for(int i=1;i<=n;i++) {
			minValue=i;
			int y=1,sq=1;
			while(sq<=i) {
				minValue=Math.min(minValue, 1+dp[i-sq]);
				y++;
				sq=y*y;
			}
			dp[i]=minValue;
		}
		return dp[n];
	}

}
