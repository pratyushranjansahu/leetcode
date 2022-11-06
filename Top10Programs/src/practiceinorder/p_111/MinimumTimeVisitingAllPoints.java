package practiceinorder.p_111;

public class MinimumTimeVisitingAllPoints {

	public static void main(String[] args) {
		int[][] points= {{1,1},{3,4},{-1,0}};
		System.out.println(minTimeToVisitAllPoints(points));
	}
	 private static int minTimeToVisitAllPoints(int[][] points) {
		 int result=0;
		 int[] p1=points[0];
		 for(int i=1;i<points.length;i++) {
			 int[] p2=points[i];
			 int dx=Math.abs(p2[0]-p1[0]);
			 int dy=Math.abs(p2[1]-p1[1]);
			 result+=Math.max(dx, dy);
			 p1=p2;
		 }
		 return result;
	 }

}
