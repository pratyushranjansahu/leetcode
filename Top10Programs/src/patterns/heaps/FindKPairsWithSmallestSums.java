package patterns.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
    https://www.youtube.com/watch?v=fYS_6C4-tfk&t=63s
    https://ttzztt.gitbooks.io/lc/content/heap/find-k-pairs-with-smallest-sums.html
 */
public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));//[[1, 2], [1, 4], [1, 6]]
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>(k);
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for(int i = 0; i < nums1.length && i < k; i++)
            pq.offer(new int []{nums1[i], nums2[0], 0}); // end of nums1
        while(k-- > 0 && !pq.isEmpty()){
            int [] cur = pq.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(cur[0]);
            temp.add(cur[1]);
            res.add(temp);
            if(cur[2] == nums2.length - 1) continue; // end of nums2
            pq.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return res;
    }
}
