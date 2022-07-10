package patterns.heaps;

import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/kth-largest-element-in-an-array/
    https://www.youtube.com/watch?v=ockS2ZKh7j8
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));// 5
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(k+1);

        for(int i:nums){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
