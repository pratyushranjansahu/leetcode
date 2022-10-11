package eightyonetoninety;

import java.util.Arrays;

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
			if(intervals[right][0] < intervals[left][1]){
				count++;
				if (intervals[right][1] <= intervals[left][1]){
					left = right;
				}
			}else {
				left = right;

			}
			right++;
		}

		return count;
	}

}
