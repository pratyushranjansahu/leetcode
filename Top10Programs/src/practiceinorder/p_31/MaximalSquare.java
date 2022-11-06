package practiceinorder.p_31;

public class MaximalSquare {

	public static void main(String[] args) {
		char[][] matrix = { { '0', '1', '1', '1' }, { '1', '1', '1', '1' }, { '0', '1', '1', '1' } };
		int targerSquare=2;
		System.out.println(maxSquare(matrix,targerSquare));
	}

	private static int maxSquare(char[][] matrix,int t) {
		int maxSquare = 0;
		int r = matrix.length;
		int c = matrix[0].length;
		int[][] sol = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 || j == 0) {
					if (matrix[i][j] == '1') {
						sol[i][j] = 1;
						maxSquare = Math.max(maxSquare, sol[i][j]);
					}
				}else {
					if (matrix[i][j] == '1') {
						int minValue=Math.min(Math.min(sol[i-1][j], sol[i][j-1]), sol[i-1][j-1]);
						sol[i][j] = minValue+1;
						maxSquare = Math.max(maxSquare, sol[i][j]);
					}
				}
			}
		}
		return maxSquare * maxSquare;
	}

}
