package patterns.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/course-schedule-iii/
    https://www.youtube.com/watch?v=EiEjHAJFnM4
 */
public class CourseScheduleIII {
    public static void main(String[] args) {
        int[][] courses = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        System.out.println(scheduleCourse(courses)); //3
    }
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a, b)-> a[1]-b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b-a);
        int time=0;
        for(int[] c:courses)
        {
            time+=c[0];
            queue.add(c[0]);
            if(time>c[1]) time-=queue.poll();
        }
        return queue.size();
    }
}
