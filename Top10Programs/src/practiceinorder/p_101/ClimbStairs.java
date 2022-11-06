package practiceinorder.p_101;

public class ClimbStairs {

	public static void main(String[] args) {
		int n=5;
		System.out.println(climb(4));

	}
	
	private static int climb(int n) {
		if(n<2) return n;
		int x=1,y=2;
		for(int i=3;i<=n;i++) {
			int temp=y;
			y+=x;
			x=temp;
		}
		
		return y;
	}

}
