package seventyonetoeighty;

public class SubarraySumsDivisibleByK {

	public static void main(String[] args) {
		int[] arr={4,5,0,-2,-3,1,15,20};
		int k=5;
		System.out.println(subarraysDivByK(arr,k));

	}
	 private static int subarraysDivByK(int[] A, int K) {
	        int[] counts = new int[K];
	        int sum = 0;
	        for(int x: A){
	            sum += (x%K + K)%K;
	            counts[sum % K]++;
	        }
	        int result = counts[0];
	        for(int c : counts)
	            result += (c*(c-1))/2;
	        return result;
	    }

}
