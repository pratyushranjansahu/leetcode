package nintyonetohundread;

public class NQueenProblem {

	public static void main(String[] args) {
		int n =4;
        int[][] chess = new int[n][n];
        printNQueens(chess,0);

	}
	public static void printNQueens(int[][] chess, int row) {
        if (row == chess.length) {
            //System.out.println(qsf + ".");
        	print2D(chess);
        	return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (chess[row][col] == 0 && isQueenSafe(chess, row, col) == true) {
                chess[row][col] = 1;
                printNQueens(chess, row + 1);
                chess[row][col] = 0;
            }
        }
    }
	  public static boolean isQueenSafe(int[][] chess, int row, int col) {
	        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
	            if (chess[i][j] == 1) {
	                return false;
	            }
	        }

	        for (int i = row - 1, j = col; i >= 0; i--) {
	            if (chess[i][j] == 1) {
	                return false;
	            }
	        }

	        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
	            if (chess[i][j] == 1) {
	                return false;
	            }
	        }

	        return true;
	    }
	  
	  public static void print2D(int mat[][]) 
	    { 
	        // Loop through all rows 
	        for (int i = 0; i < mat.length; i++) { 
	  
	            // Loop through all elements of current row 
	            for (int j = 0; j < mat[i].length; j++) { 
	                System.out.print(mat[i][j] + " ");
	            	
	            }
	            System.out.println();
	        }
	        System.out.println("***************************");
	    } 

}
