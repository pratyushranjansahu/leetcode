package patterns.intervals;

import java.util.Arrays;
/*
	https://leetcode.com/problems/non-overlapping-intervals/
	https://www.youtube.com/watch?v=BTObFnHbD4U&t=814s
 */
public class NonOverlappingIntervals {

	public static void main(String[] args) {
		int[][] intervals= {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals(intervals));

	}

	public static int eraseOverlapIntervals(int[][] intervals) {
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
