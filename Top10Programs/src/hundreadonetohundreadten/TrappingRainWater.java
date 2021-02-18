package hundreadonetohundreadten;
//https://www.youtube.com/watch?v=gIZSOpW-SN0
public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int trap(int[] height) {
	        
	        int n = height.length;
	        int totalwater = 0;
	        int max = 0;
	        int maxIndex = 0;
	        
	        for(int i=0;i<n;i++){
	           if(height[i]>max){
	               max = height[i]; //rmax
	               maxIndex = i;
	           }
	        }
	        
	        int leftMax = 0;
	        //part1
	        for(int i=0;i<maxIndex;i++){
	           leftMax = Math.max(leftMax,height[i]);
	           int water = Math.min(leftMax,max)-height[i];
	           totalwater += water;
	        }
	        
	        leftMax = 0;
	        //part2
	         for(int i=n-1;i>maxIndex;i--){
	           leftMax = Math.max(leftMax,height[i]);
	           int water = Math.min(leftMax,max)-height[i];
	           totalwater += water;
	        }
	        
	        
	        return totalwater;
	    }
	

}
