package thirtyonetoforty;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 3,4,2, 2,2,2 };
		int k = 3;
		System.out.println(frequentElements(nums, k));

	}

	private static int[] frequentElements(int[] nums, int k) {
		if(k == nums.length) return nums;
		int[] result = new int[k];
		Map<Integer,Integer> counts=new HashMap();
		for(int num : nums)
			counts.put(num, counts.getOrDefault(num, 0)+1);
		PriorityQueue<Integer> pq=new PriorityQueue((a,b)-> -counts.get(a).compareTo(counts.get(b)));
		//PriorityQueue<Integer> pq = new PriorityQueue(counts.size(),Comparator.reverseOrder());
		
		for(int key : counts.keySet())
			pq.add(key);
		for(int i=0;i<k;i++) {
			result[i]=pq.poll();
		}
		
		return result;
	}

}
