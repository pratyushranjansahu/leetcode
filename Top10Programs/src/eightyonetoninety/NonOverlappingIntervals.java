package eightyonetoninety;

import java.util.Arrays;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		int[][] intervals= {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals1(intervals));

	}
	
	  private static int eraseOverlapIntervals(int[][] intervals) {
	        if(intervals.length < 2) return 0;
	        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));
	        int count = 0, last_included = 0;
	        for(int i = 1; i < intervals.length; ++i){
	            if(intervals[i][0] < intervals[last_included][1]){ // Overlap
	                count++;
	                if(intervals[i][1] < intervals[last_included][1]) last_included = i;
	            } else 
	                last_included = i;
	        }
	        return count;
	    }
	  
	  private static int eraseOverlapIntervals1(int[][] intervals) {
	        if(intervals.length < 2) return 0;
	        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));
	        int count = 0;      //Count of number of intervals to be removed
	        int n = intervals.length;   //No of intervals
	        int left = 0;   //left interval
	        int right = 1;  //right interval
	        
	        while(right<n)  //Unless all intervals are compared
	        {
	            if(intervals[left][1] <= intervals[right][0])   //Non-overlapping case
	            {
	                left = right;
	                right+=1;
	            }
	            else if(intervals[left][1]<=intervals[right][1])    //Overlapping case-1 (Remove right interval)
	            {
	                count+=1;       //Delete right
	                right+=1;
	            }
	            else if(intervals[left][1]>intervals[right][1])     //Overlapping case-2 (Remove left interval)
	            {
	                count+=1;
	                left = right;
	                right+=1;
	            }
	        }
	        
	        return count;
	    }

}
