package practiceinorder.p_101;

public class FindTheTownJudge {

	public static void main(String[] args) {
		int[][] trust={{1,3},{2,3}};
		int N=3;
		System.out.println(isJudge(N, trust));

	}
	
	private static int isJudge(int N,int[][] trust) {
		int[] trustCount=new int[N];
		for(int[] t : trust) {
			trustCount[t[0]-1]--;
			trustCount[t[1]-1]++;
			
		}
		
		int result=-1;
		for(int i=0;i<N;i++) {
			if(trustCount[i]==N-1)
				return i+1;
		}
		return result;
		
	}

}
