package practiceinorder.p_171;
/*
    https://leetcode.com/problems/unique-paths-iii/description/
    https://www.youtube.com/watch?v=172yYUwdf-I
 */
public class UniquePathIII {

    static int ans = 0;
    static int nonObstacle = 1;
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePathsIII(grid));//2
    }
    public static int uniquePathsIII(int[][] grid) {
        // store the starting position.
        int startX = 0;
        int startY = 0;

        // find the starting location and number of non-obstacle square.
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++){
                // if we got the starting position.
                if(grid[i][j] == 1){startX = i; startY =j;}
                else if(grid[i][j] == 0){nonObstacle++;}
            }
        }

        // call the dfs from the starting position.
        dfs(startX,startY,grid,0);
        return ans;
    }

    static void  dfs(int i,int j,int[][] grid,int count){
        //    base condtion.
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length ||grid[i][j] == -1){
            return ;
        }
        if(grid[i][j] == 2){
            // if we got all the nonobstacle cover.
            if(count == nonObstacle){
                ans++;
            }
            return;
        }

        // make current node visited.
        grid[i][j] = -1;

        // Traversal.
        dfs(i+1,j,grid,count+1);
        dfs(i-1,j,grid,count+1);
        dfs(i,j+1,grid,count+1);
        dfs(i,j-1,grid,count+1);


        // backtracking make it non-visited.
        grid[i][j] = 0;

    }
}
