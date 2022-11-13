package practiceinorder.p_121;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=VC9BYJvFeC8
public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		System.out.println(pacificAtlantic(matrix));

	}

	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> cord = new ArrayList();
		if (matrix.length == 0)
			return cord;

		int row = matrix.length;
		int col = matrix[0].length;

		int[][] paci = new int[row][col];
		int[][] alt = new int[row][col];

		// first row (pacific)
		for (int i = 0; i < col; i++) {
			dfs(matrix, 0, i, paci, Integer.MIN_VALUE);
		}
		// first col (pacific)
		for (int i = 0; i < row; i++) {
			dfs(matrix, i, 0, paci, Integer.MIN_VALUE);
		}
		// last row (altantic)
		for (int i = 0; i < col; i++) {
			dfs(matrix, row - 1, i, alt, Integer.MIN_VALUE);
		}
		// last col (altantic)
		for (int i = 0; i < row; i++) {
			dfs(matrix, i, col - 1, alt, Integer.MIN_VALUE);
		}

		for (int i = 0; i < paci.length; i++) {
			for (int j = 0; j < paci[0].length; j++) {
				if (paci[i][j] == 1 && alt[i][j] == 1) {
					List<Integer> c = new ArrayList();
					c.add(i);
					c.add(j);
					cord.add(c);
				}
			}
		}

		return cord;
	}

	private static void dfs(int[][] matrix, int row, int col, int[][] temp, int pre) {

		if (row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1)
			return;
		else if (pre > matrix[row][col])
			return;
		else if (temp[row][col] == 1)
			return;

		temp[row][col] = 1;

		dfs(matrix, row + 1, col, temp, matrix[row][col]);
		dfs(matrix, row - 1, col, temp, matrix[row][col]);
		dfs(matrix, row, col - 1, temp, matrix[row][col]);
		dfs(matrix, row, col + 1, temp, matrix[row][col]);
	}

}
