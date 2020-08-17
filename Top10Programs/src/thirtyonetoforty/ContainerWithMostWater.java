package thirtyonetoforty;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] heights= {1,8,6,2,5,4,8,3,7};
		System.out.println(calculateArea(heights));

	}

	private static int calculateArea(int[] heights) {
	
		int start=0;
		int end=heights.length-1;
		int maxArea=0;
		while(start<end) {
			int height=Math.min(heights[start], heights[end]);
			int area=height*(end-start);
			if(area>maxArea) {
				maxArea=area;
			}
			if(heights[start]<heights[end])
				start++;
			else
				end--;
			
			
		}
		return maxArea;
	}
}
