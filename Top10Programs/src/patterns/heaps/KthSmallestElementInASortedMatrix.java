package patterns.heaps;

import java.util.PriorityQueue;

/*
    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    https://www.youtube.com/watch?v=F22d27HJsxg&t=2s
 */
public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int  k = 8;
        System.out.println(kthSmallest(matrix, k));//13
    }
    // Solution One TC : O(nlogk)
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
