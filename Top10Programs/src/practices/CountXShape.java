package practices;

public class CountXShape {

	public static void main(String[] args) {
		int n = 3;
		int k = 3;
		char[][] arr = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'X', 'X' } };
		boolean visited[][] = new boolean[n][k];
		int count = 0;
		boolean flag;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (arr[i][j] == 'X' && !visited[i][j]) {
					DFS(visited, arr, i, j, n, k);
					count++;
				}
			}
		}

		System.out.println(count);

	}

	public static void DFS(boolean visited[][], char arr[][], int i, int j, int n, int k) {
		if (arr[i][j] == 'X' && !visited[i][j]) {
			visited[i][j] = true;
			if (i + 1 < n)
				DFS(visited, arr, i + 1, j, n, k);
			if (i - 1 >= 0)
				DFS(visited, arr, i - 1, j, n, k);
			if (j + 1 < k)
				DFS(visited, arr, i, j + 1, n, k);
			if (j - 1 >= 0)
				DFS(visited, arr, i, j - 1, n, k);
		} else
			return;
	}
}
