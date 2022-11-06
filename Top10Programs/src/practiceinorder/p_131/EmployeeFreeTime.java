package practiceinorder.p_131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
    LeetCode
    https://www.youtube.com/watch?v=tafUkDPWIbM&t=323s
 */
public class EmployeeFreeTime {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,7},{2,4},{2,5},{9,12}};
        System.out.println(merge(intervals));
    }
    public static  List<List<Integer>> merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0],b[0])); //O(nlogn)
        Stack<int[]> stack = new Stack(); //O(n)
        stack.add(intervals[0]);


        for(int i=1;i<intervals.length;i++){

            int startpoint2 = intervals[i][0];
            int endpoint2 = intervals[i][1];

            int[] poparray = stack.pop();

            int startpoint1 = poparray[0];
            int endpoint1 = poparray[1];

            int endmax = Math.max(endpoint2,endpoint1);

            if(endpoint1>=startpoint2){
                int[] merge = new int[]{startpoint1,endmax};
                stack.add(merge);
            }else{
                stack.add(poparray);
                stack.add(intervals[i]);
                List<Integer> l = new ArrayList();
                l.add(endpoint1);
                l.add(startpoint2);
                res.add(l);
            }

        }

        return res;
    }
}
