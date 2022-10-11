package patterns.intervals;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/insert-interval/
    https://www.youtube.com/watch?v=dxbRB6gWCqg
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        insert(intervals, newInterval);//[[1,5],[6,9]]
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        int i = 0, n = intervals.length;
        while (i < n){
            if (intervals[i][0] < newInterval[0]){
                result.add(intervals[i]);
                i++;
            }else {
                break;
            }
        }
        if (result.size() == 0 || newInterval[0] > result.get(result.size() - 1)[1]){
            result.add(newInterval);
        }else {
            int[] lastInterval = result.get(result.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1],newInterval[1]);
        }

        while (i < n){
            int[] lastInterval = result.get(result.size() - 1);
            if (lastInterval[1] >= intervals[i][0]){
                lastInterval[1] = Math.max(lastInterval[1],intervals[i][1]);
            }else {
                result.add(intervals[i]);
            }
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }
}
