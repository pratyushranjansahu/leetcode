package hundreadtwintyonetothirty;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumCostPathFromBottomLeftToRightTop {

	public static void main(String[] args) {
		int mat[][] = { { 20, -10, 0 }, { 1, 5, 10 }, { 1, 2, 3 } };

		System.out.println("Given matrix is ");

		printMAtrix(mat);

		System.out.print("Maximum cost is " + find_max_cost(mat));

	}

	static int ROW = 3;
	static int COL = 3;

	// To store matrix cell coordinates
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// Check whether given cell (row, col)
	// is a valid cell or not.
	static boolean isValid(Point p) {
		// Return true if row number and column number
		// is in range
		return (p.x >= 0) && (p.y < COL);
	}

	// Function to find maximum cost to reach
	// top right corner from bottom left corner
	static int find_max_cost(int mat[][]) {
		int[][] max_val = new int[ROW][COL];
		max_val[ROW - 1][0] = mat[ROW - 1][0];

		// Starting point
		Point src = new Point(ROW - 1, 0);

		// Create a queue for traversal
		Queue<Point> q = new LinkedList<>();

		q.add(src); // Enqueue source cell

		// Do a BFS starting from source cell
		// on the allowed direction
		while (!q.isEmpty()) {
			Point curr = q.peek();
			q.remove();

			// Find up point
			Point up = new Point(curr.x - 1, curr.y);

			// if adjacent cell is valid, enqueue it.
			if (isValid(up)) {
				max_val[up.x][up.y] = Math.max(max_val[up.x][up.y], mat[up.x][up.y] + max_val[curr.x][curr.y]);
				q.add(up);
			}

			// Find right point
			Point right = new Point(curr.x, curr.y + 1);

			if (isValid(right)) {
				max_val[right.x][right.y] = Math.max(max_val[right.x][right.y],
						mat[right.x][right.y] + max_val[curr.x][curr.y]);
				q.add(right);
			}
			System.out.println("Quese");
			printMAtrix(max_val);

		}

		// Return the required answer
		return max_val[0][COL - 1];
	}

	
	private static void printMAtrix(int[][] mat) {
		for (int i = 0; i < ROW; ++i) {
			for (int j = 0; j < COL; ++j)
				System.out.print(mat[i][j] + " ");

			System.out.println();
		}
	}
}
