package practiceinorder.p_21;

import java.util.Stack;

//https://www.youtube.com/watch?v=Q39oYu4p9gY&t=468s
public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maximalRectangle(char[][] matrix) {
	        if(matrix.length==0) return 0;
	        int max=0;  
	        int[] heights=new int[matrix[0].length];
	        
	        for(int i=0;i<matrix.length;i++){
	            for(int j=0;j<matrix[0].length;j++){
	                if(matrix[i][j]=='0')
	                    heights[j]=0;
	                else
	                    heights[j]+=1;
	            }
	            
	            max=Math.max(max,largestRectangleArea(heights));
	        }
	        return max;
	    }
	    
	    public  int largestRectangleArea(int[] heights) {
		    
	        
		    int[] left = new int[heights.length]; 
		    int[] right = new int[heights.length];
		    int[] width = new int[heights.length];
		    Stack<Integer> stack = new Stack();
		        
		        
		       //width --- left
		        for(int i=0;i<heights.length;i++){
		            
		            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
		                stack.pop();
		            }
		            
		            if(stack.isEmpty()){
		                left[i] = -1;
		            }else{
		                left[i] = stack.peek();
		            }
		            
		            stack.add(i);
		        }
		        stack.clear();
		        //width --- right
		        for(int i=heights.length-1;i>=0;i--){
		            
		            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
		                stack.pop();
		            }
		            
		            if(stack.isEmpty()){
		                right[i] = heights.length;
		            }else{
		                right[i] = stack.peek();
		            }
		            
		            stack.add(i);
		        }
		        
		        int area = 0;
		        
		         for(int i=0;i<heights.length;i++){
		            width[i] = right[i]-left[i]-1;
		            area = Math.max(heights[i]* width[i] ,area);
		         }
		        
		        return area;
		    }

}
