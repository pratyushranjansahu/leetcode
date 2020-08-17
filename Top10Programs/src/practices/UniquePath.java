package practices;

public class UniquePath {

	public static void main(String[] args) {
		System.out.println(findpath(2, 3));

	}
	
	private static int findpath(int m,int n) {
		int[][] arr=new int[n][m];
		int r=arr.length;
		int c=arr[0].length;
		for(int i=n-2;i>=0;i--)
			arr[i][c-1]=1;
		for(int j=m-1;j>=0;j--)
			arr[r-1][j]=1;
		for(int i=n-2;i>=0;i--) {
			for(int j=m-2;j>=0;j--) {
				arr[i][j]=arr[i+1][j]+arr[i][j+1];
			}
		}
		return arr[0][0];
	}

}
