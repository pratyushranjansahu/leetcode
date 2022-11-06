package practiceinorder.p_131;
/*
    https://leetcode.com/problems/max-area-of-island/
    https://www.youtube.com/watch?v=_wLMk_Qbl08
 */
public class MaxAreaofIsland {
    public static void main(String[] args) {
        int[][]  grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));//6
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int result = 0;
        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j)
                if(grid[i][j] == 1) result = Math.max(result, dfs(grid, i, j));
        }
        return result;
    }
    private static int dfs(int[][] grid, int i, int j){
        int r = grid.length;
        int c = grid[0].length;
        if(i < 0 || j < 0 || i >= r || j >= c || grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        return (1 + dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1));
    }
}
