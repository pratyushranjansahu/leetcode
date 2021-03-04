package hundreadeleventotwinty;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		//[1,13,14,5,7,12] -> 13 14 -1 7 12 -1
		int[] arr= {1,13,14,5,7,12};
		int[] ret=nextGreater(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+"  "+ret[i]);
		}

	}
	
	private static int[] nextGreater(int[] heights) {
		int[] right=new int[heights.length];
		Stack<Integer> stack=new Stack();
		 
	        //width --- right
	        for(int i=heights.length-1;i>=0;i--){
	            
	            while(!stack.isEmpty() && heights[i]>=stack.peek()){
	                stack.pop();
	            }
	            
	            if(stack.isEmpty()){
	                right[i] = -1;
	            }else{
	                right[i] = stack.peek();
	            }
	            
	            stack.add(heights[i]);
	        
	        }
	        return right;
	}

}
