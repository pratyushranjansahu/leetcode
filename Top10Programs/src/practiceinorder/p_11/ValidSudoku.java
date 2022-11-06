package practiceinorder.p_11;

import java.util.HashSet;
import java.util.Set;
//https://www.youtube.com/watch?v=rJ9NFK9s_mI
public class ValidSudoku {

	public static void main(String[] args) {
		Set<Integer> set=new HashSet<>();
		System.out.println(set.add(1));
		System.out.println(set.add(1));
		System.out.println(!false);
	}
	
	 public static boolean isValidSudoku(char[][] board) {
	      
	      HashSet<String> seen = new HashSet<String>();
	      for(int i=0;i<9;i++){
	          for(int j=0;j<9;j++){
	            if(board[i][j]!='.'){
	             if(!seen.add("row"+i+board[i][j]) || !seen.add("column"+j+board[i][j]) ){
	                 return false;
	             }
	             if(!seen.add("box"+(i/3)*3+j/3+board[i][j])){
	                 return false;
	             }
	            } 
	          }
	      }
	      return true;
	  }

}
