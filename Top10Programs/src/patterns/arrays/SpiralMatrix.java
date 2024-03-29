package patterns.arrays;

import java.util.ArrayList;
import java.util.List;
/*
	https://leetcode.com/problems/spiral-matrix/
	https://www.youtube.com/watch?v=JkWDKg_pNME&t=286s
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix= {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		System.out.println(spiralOrder(matrix));

	}
	 public  static List<Integer> spiralOrder(int[][] matrix) {
	        
	        List<Integer> list = new ArrayList();

	        int row = matrix.length;  
	        if(row ==0 )return list;
	        int col = matrix[0].length;
	        
	        
	       
	        
	        int l = 0 , r = col-1 , t = 0 ,  b = row-1 , d = 0;
	        
	        while(l<=r && t<=b){
	            if(d==0){
	                for(int i=l;i<=r;i++){
	                    list.add(matrix[t][i]);
	                }
	                d=1;t++;
	            }else if(d==1){
	                  for(int i=t;i<=b;i++){
	                      list.add(matrix[i][r]);
	                  }    
	                d=2;r--;
	            }else if (d==2){
	                for(int i =r;i>=l;i--){
	                    list.add(matrix[b][i]);
	                }
	                d=3;b--;
	            }else if (d==3){
	                for(int i = b;i>=t;i--){
	                     list.add(matrix[i][l]);
	                }
	               d=0;l++; 
	            }
	        }
	        return list;

	    }
}
