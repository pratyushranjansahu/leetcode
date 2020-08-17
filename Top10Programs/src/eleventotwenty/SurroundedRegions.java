package eleventotwenty;

public class SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'O', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

	}

	private static void regions(char[][] board) {
		int r = board.length;
		if (r <= 2)
			return;
		int c = board[0].length;
		if (c <= 2)
			return;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if ((board[i][j] == 'O') && (i == 0 || j == 0 || i == r - 1 || j == c - 1))
					dfs(board, i, j);
			}
		}
		
		
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(board[i][j]=='O')
					board[i][j]='X';
				if(board[i][j]=='A')
					board[i][j]='O';
			}
		}
	}

	private static void dfs(char[][] board, int i, int j) {
		  if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='O'){
				board[i][j] = 'A';
				dfs(board, i - 1, j);
				dfs(board, i + 1, j);
				dfs(board, i, j - 1);
				dfs(board, i, j + 1);
			}

	}

}
