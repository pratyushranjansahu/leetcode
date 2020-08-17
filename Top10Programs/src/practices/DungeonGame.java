package practices;

public class DungeonGame {

	public static void main(String[] args) {
		int[][] arr = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(arr));

	}
	
	private static int calculateMinimumHP(int[][] dungeon) {
		int[][] sol=new int[dungeon.length][dungeon[0].length];
		int r=sol.length;
		int c=sol[0].length;
		sol[r-1][c-1]=dungeon[r-1][c-1]>0?1:1-dungeon[r-1][c-1];
		for(int i=r-2;i>=0;i--) 
			sol[i][c-1]=Math.max(sol[i+1][c-1]-dungeon[i][c-1], 1);
		for(int j=c-2;j>=0;j--)
			sol[r-1][j]=Math.max(sol[r-1][j+1]-dungeon[r-1][j], 1);
		for(int i=r-2;i>=0;i--) {
			for(int j=c-2;j>=0;j--) {
				sol[i][j]=Math.max(Math.min(sol[i+1][j],sol[i][j+1])-dungeon[i][j], 1);
			}
		}
		
		return sol[0][0];
	}

}
