package patterns.intervals;

import java.util.Arrays;
import java.util.Stack;
/*
    Leetcode
    https://www.youtube.com/watch?v=KiAZTXAGIsI&t=683s
 */
public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{4,6},{8,10},{15,18}};
        System.out.println(canAttendMeetings(intervals)); //true
    }
    public static boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0)return true;
        Arrays.sort(intervals , (a, b)->Integer.compare(a[0],b[0])); //O(nlogn)
        Stack<int[]> stack = new Stack(); //O(n)
        stack.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){

            int startpoint2 = intervals[i][0];
            int endpoint2 = intervals[i][1];

            int[] poparray = stack.pop();
            int startpoint1 = poparray[0];
            int endpoint1 = poparray[1];

            if(endpoint1>startpoint2){
                return false;
            }

            stack.add(intervals[i]);
        }
        return true;
    }
}
