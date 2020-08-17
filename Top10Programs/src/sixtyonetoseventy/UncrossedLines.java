package sixtyonetoseventy;

public class UncrossedLines {

	public static void main(String[] args) {
		int[] A= {1,4,2};
		int[] B={1,2,4};
		System.out.println(maxUncrossedLines(A, B));

	}
	private static int maxUncrossedLines(int[] A, int[] B) {
		int m=A.length;
		int n=B.length;
		int[][] sol=new int[m+1][n+1];
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(A[i-1]==B[j-1]) {
					sol[i][j]=1+sol[i-1][j-1];
				}else {
					sol[i][j]=Math.max(sol[i][j-1],sol[i-1][j]);
				}
			}
		}
		return sol[m][n];
	}

}
