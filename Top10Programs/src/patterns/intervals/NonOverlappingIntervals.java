package patterns.intervals;

import java.util.Arrays;
/*
	https://leetcode.com/problems/non-overlapping-intervals/
	https://www.youtube.com/watch?v=evA9Z5p16bI&t=59s
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
		int prev = 0;   //left interval
		//int right = 1;  //right interval

		for(int current = 1; current < n; current++){

			if(intervals[current][0] < intervals[prev][1]){
				count++;
				if(intervals[current][1] <= intervals[prev][1]){
					prev = current;
				}
			}else{
				prev = current;
			}

		}

		return count;
	}
}
