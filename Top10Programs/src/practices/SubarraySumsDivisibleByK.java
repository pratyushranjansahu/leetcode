package practices;

import java.util.ArrayList;
import java.util.List;

public class SubarraySumsDivisibleByK {

	public static void main(String[] args) {
		int[] arr={4,5,0,-2,-3,1};
		int k=5;
		//System.out.println(subarraysDivByK(arr,k));
		
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		//list.stream().map(mapper)
		list.forEach(System.out::println);


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
