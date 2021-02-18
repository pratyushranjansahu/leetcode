package hundreadonetohundreadten;

import java.util.Stack;
//https://www.youtube.com/watch?v=t8p5FS6flw8
public class LargestHistogram {

	public static void main(String[] args) {
		//int[] arr = { 2, 1, 5, 6, 2, 3 };
		int[] arr = { 2, 1, 5, 6, 5, 3 };
		// int[] arr= {5,6,7};
		// int[] arr= {1,1};
		System.out.println(largestRectangleArea(arr));

	}

	public static int largestRectangleArea(int[] heights) {
	    
        
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
