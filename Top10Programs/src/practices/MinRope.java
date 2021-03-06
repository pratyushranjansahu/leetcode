package practices;

import java.util.PriorityQueue;

public class MinRope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 static long minCost(long arr[], int n) 
	    { 
	        // Create a priority queue 
	        PriorityQueue<Long> pq = new PriorityQueue<Long>(); 
	  
	        // Adding items to the pQueue 
	        for (int i = 0; i < n; i++) { 
	            pq.add(arr[i]); 
	        } 
	  
	        // Initialize result 
	        long res = 0; 
	  
	        // While size of priority queue 
	        // is more than 1 
	        while (pq.size() > 1) { 
	            // Extract shortest two ropes from pq 
	            long first = pq.poll(); 
	            long second = pq.poll(); 
	  
	            // Connect the ropes: update result 
	            // and insert the new rope to pq 
	            res += first + second; 
	            pq.add(first + second); 
	        } 
	  
	        return res; 
	    } 
	  

}
