package practiceinorder.p_1;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
    Leet code
    https://www.youtube.com/watch?v=bgZmJiPfkYE&t=523s
 */
public class MeetingRoomII {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals)); // 2
    }
    public static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> p = new PriorityQueue();//O(n)

        for(int[] interval : intervals){

            if(p.isEmpty()){
                p.add(interval[1]);
                continue;
            }

            if(p.peek()<=interval[0]){//same room
                p.remove();
            }

            p.add(interval[1]); //O(nlogn)
        }

        return p.size();
    }
}
