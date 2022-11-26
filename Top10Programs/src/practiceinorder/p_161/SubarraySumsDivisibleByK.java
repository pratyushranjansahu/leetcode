package practiceinorder.p_161;

/*
	https://leetcode.com/problems/subarray-sums-divisible-by-k/
	https://www.youtube.com/watch?v=u9m-hnlcydk&t=463s
 */
public class SubarraySumsDivisibleByK {

	public static void main(String[] args) {
		int[] arr={4,5,0,-2,-3,1};
		int k=5;
		System.out.println(subarraysDivByK(arr,k));

	}
	 private static int subarraysDivByK(int[] A, int K) {
	        int[] counts = new int[K];
	        int sum = 0;
	        for(int x: A){
	        	System.out.println("x value is : "+x+" Mod value is : "+((x%K + K)%K));
	            sum += (x%K + K)%K;
	            counts[sum % K]++;
	        }
	        int result = counts[0];
	        for(int c : counts)
	            result += (c*(c-1))/2;
	        return result;
	    }

}
