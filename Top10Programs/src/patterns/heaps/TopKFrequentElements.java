package patterns.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
	https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
	https://www.youtube.com/watch?v=X45CT-YbzKE&t=334s
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		//int[] nums = { 1, 1, 1, 3,4,2, 2,2,2 };
		//int k = 3;
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		int[] res = frequentElements(nums, k);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");//[1,2]
		}
	}

	private static int[] frequentElements(int[] nums, int k) {
		if(k == nums.length) return nums;
		int[] result = new int[k];
		Map<Integer,Integer> counts=new HashMap();
		for(int num : nums)
			counts.put(num, counts.getOrDefault(num, 0)+1);
		PriorityQueue<Integer> pq=new PriorityQueue((a,b)-> -counts.get(a).compareTo(counts.get(b)));
			
		for(int key : counts.keySet())
			pq.add(key);
		for(int i=0;i<k;i++) {
			result[i]=pq.poll();
		}
		
		return result;
	}

}
