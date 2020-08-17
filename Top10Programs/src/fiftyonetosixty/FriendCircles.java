package fiftyonetosixty;

public class FriendCircles {

	public static void main(String[] args) {
		int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(M));
	}

	private static int findCircleNum(int[][] M) {
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if (M[i][i] == 1) {
				count++;
				dfs(M, i);
			}
		}
		return count;
	}

	private static void dfs(int[][] M, int v) {
		if (M[v][v] == 0)
			return;
		for (int i = 0; i < M.length; i++) {
			if (M[v][i] == 1) {
				M[v][i] = 0;
				dfs(M, i);
			}
		}
	}

}
