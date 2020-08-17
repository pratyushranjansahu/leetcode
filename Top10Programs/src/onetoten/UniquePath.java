package onetoten;

public class UniquePath {

	public static void main(String[] args) {
		System.out.println(uniquePath(3,7));

	}
	
	private static int uniquePath(int m,int n) {
		int[][] path=new int [m][n];
		int r=path.length;
		int c=path[0].length;
		for (int i = r-2; i >=0; i--) 
			path[i][c-1]=1;
		for (int j = c-2; j >= 0; j--) 
			path[r-1][j]=1;
		
		for (int i = r-2; i >=0; i--) {
			for (int j = c-2; j >=0; j--) {
				path[i][j]=path[i][j+1]+path[i+1][j];
			}
		}
		
		return path[0][0];
	}

}
