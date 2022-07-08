package patterns.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * https://leetcode.com/problems/sliding-window-median/
 * https://www.youtube.com/watch?v=NT5Lp5vaMm0
 */
public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] arr = medianSlidingWindow(nums, k);
        for (double d : arr) {
            System.out.println(d+" ");//[1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
        }
    }
    static Queue<Integer> minHeap, maxHeap;
    public static double[] medianSlidingWindow(int[] nums, int k) {

        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer
                .compare(nums[a], nums[b]) : a - b;
        minHeap = new PriorityQueue<Integer>(comparator);
        maxHeap = new PriorityQueue<Integer>(comparator.reversed());
        double[] res = new double[nums.length - k + 1];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                minHeap.remove(i - k);
                maxHeap.remove(i - k);
            }
            minHeap.add(i);
            maxHeap.add(minHeap.poll());

            balanceHeap();

            if (i >= k - 1) {
                res[ans++] = getMedian(nums, k);
            }
        }
        return res;
    }

    private static double getMedian(int[] nums, int k) {
        if (k % 2 == 0)
            return ((double) nums[minHeap.peek()] + nums[maxHeap.peek()]) / 2;

        return (double) nums[minHeap.peek()];
    }

    private static void balanceHeap() {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }
}
