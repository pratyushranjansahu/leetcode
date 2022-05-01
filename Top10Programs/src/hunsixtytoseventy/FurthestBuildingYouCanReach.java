package hunsixtytoseventy;

import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/furthest-building-you-can-reach/
    https://www.youtube.com/watch?v=7LmgzOCnZQk
 */
public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(furthestBuilding(heights, bricks, ladders)); //4
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < heights.length-1; i++) {
            int difference = heights[i+1] - heights[i];
            if (difference > 0) {
                priorityQueue.add(difference);
            }
            if (priorityQueue.size() > ladders) {
                bricks -= priorityQueue.poll();
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}
