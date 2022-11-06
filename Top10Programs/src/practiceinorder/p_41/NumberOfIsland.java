package practiceinorder.p_41;

public class NumberOfIsland {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numberOfIsland(grid));

	}

	private static int numberOfIsland(char[][] grid) {
		int r=grid.length;
		if(r==0)return 0;
		int c=grid[0].length;
		if(c==0) return 0;
		int count=0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(grid[i][j]=='1') {
					count++;
					dfs(grid,i,j);
				}
					
			}
		}
		return count;
				
	}
	
	private static void dfs(char[][] grid,int i,int j) {
		grid[i][j]='M';
		if(i>0&& grid[i-1][j]=='1')
			dfs(grid, i-1, j);
		if(i+1<grid.length&& grid[i+1][j]=='1')
			dfs(grid, i+1, j);
		if(j>0&& grid[i][j-1]=='1')
			dfs(grid, i, j-1);
		if(j+1<grid[0].length&& grid[i][j+1]=='1')
			dfs(grid, i, j+1);
		
		  
		
	}
}
