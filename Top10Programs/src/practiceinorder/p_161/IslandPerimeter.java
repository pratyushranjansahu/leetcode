package practiceinorder.p_161;
/*
	https://leetcode.com/problems/island-perimeter/
	https://www.youtube.com/watch?v=UcEYCLPWREQ&t=349s
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(islandPerimeter(grid));
	}

	private static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int r = grid.length;
		int c = grid[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 0)
					continue;
				perimeter += 4;
				if (i > 0)
					perimeter -= grid[i - 1][j];
				if (i + 1 < grid.length)
					perimeter -= grid[i + 1][j];
				if (j > 0)
					perimeter -= grid[i][j - 1];
				if (j + 1 < grid[0].length)
					perimeter -= grid[i][j + 1];
			}
		}
		return perimeter;
	}

}
