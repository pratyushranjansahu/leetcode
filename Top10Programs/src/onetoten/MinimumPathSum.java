package onetoten;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{1,3,1},{1,5,1},{4,2,1}};
		int[][] path=arr;
		int r=path.length;
		int c=path[0].length;		
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[0].length; j++) {
				if(i>0 && j>0) {
					path[i][j]+=Math.min(path[i-1][j], path[i][j-1]);
				}else {
					if(i>0) {
						path[i][j]+=path[i-1][j];
					}
					if(j>0) {
						path[i][j]+=path[i][j-1];
					}
				}
			}
		}
		
		System.out.println(path[r-1][c-1]);
	}
	
	

}
