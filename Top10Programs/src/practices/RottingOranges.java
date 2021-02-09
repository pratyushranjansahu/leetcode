package practices;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting(grid));

	}

	private static int orangesRotting(int[][] grid) {
		Queue<int[]> rotten = new LinkedList();
		int r = grid.length, c = grid[0].length, fresh = 0, t = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (grid[i][j] == 2)
					rotten.offer(new int[] { i, j });
				else if (grid[i][j] == 1)
					fresh++;
			}
		}

		while (!rotten.isEmpty()) {
			int num = rotten.size();
			for (int i = 0; i < num; ++i) {
				int x = rotten.peek()[0], y = rotten.peek()[1];
				rotten.remove();
				if (x > 0 && grid[x - 1][y] == 1) {
					grid[x - 1][y] = 2;
					fresh--;
					rotten.offer(new int[] { x - 1, y });
				}
				;
				if (y > 0 && grid[x][y - 1] == 1) {
					grid[x][y - 1] = 2;
					fresh--;
					rotten.offer(new int[] { x, y - 1 });
				}
				;
				if (x < r - 1 && grid[x + 1][y] == 1) {
					grid[x + 1][y] = 2;
					fresh--;
					rotten.offer(new int[] { x + 1, y });
				}
				;
				if (y < c - 1 && grid[x][y + 1] == 1) {
					grid[x][y + 1] = 2;
					fresh--;
					rotten.offer(new int[] { x, y + 1 });
				}
				;
			}
			if (!rotten.isEmpty())
				t++;
		}
		return (fresh == 0) ? t : -1;
	}

}
