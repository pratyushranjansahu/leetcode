package patterns.twopointer;
//https://www.youtube.com/watch?v=gIZSOpW-SN0
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height)); // 6
	}

	public static int trap(int[] height) {

		int n = height.length;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		int max = 0;
		int totalwater = 0;


		for(int i=0;i<n;i++){
			max = Math.max(max,height[i]);
			leftMax[i] = max;
		}

		max = 0;

		for(int i=n-1;i>=0;i--){
			max = Math.max(max,height[i]);
			rightMax[i] = max;
		}

		for(int i=1;i<n-1;i++){
			int water = Math.min(leftMax[i],rightMax[i])-height[i];
			totalwater += water;
		}
		return totalwater;
	}
}
