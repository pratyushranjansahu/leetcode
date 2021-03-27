package onetoten;

public class CountSquareSubMatrices {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, {0, 1, 1, 1 } };
		System.out.println(countMatrices(matrix));

	}
	
	private static int countMatrices(int[][] matrix) {
		int count=0;
		int maxSquare = 0;
		int r = matrix.length;
		if(r==0) return 0;
		int c = matrix[0].length;
		if (c==0) return 0;
		int[][] sol = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 || j == 0) {
					if (matrix[i][j] == 1) {
						count++;
						sol[i][j] = 1;
						//maxSquare = Math.max(maxSquare, sol[i][j]);
					}
				}else {
					if (matrix[i][j] == 1) {
						int minValue=Math.min(Math.min(sol[i-1][j], sol[i][j-1]), sol[i-1][j-1]);
						sol[i][j] = minValue+1;
						//maxSquare = Math.max(maxSquare, sol[i][j]);
						count+=sol[i][j];
					}
				}
			}
		}
		return count;
	}

}
