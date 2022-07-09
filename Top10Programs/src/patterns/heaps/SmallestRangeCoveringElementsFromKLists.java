package patterns.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
/*
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 * https://www.youtube.com/watch?v=aH-2Sig2H2Q
 */
public class SmallestRangeCoveringElementsFromKLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(new Integer[]{4,10,15,24,26});
        List<Integer> list2 = Arrays.asList(new Integer[]{0,9,12,20});
        List<Integer> list3 = Arrays.asList(new Integer[]{5,18,22,30});
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        nums.add(list1);
        nums.add(list2);
        nums.add(list3);
        int[] res = smallestRange(nums);
        System.out.println("result vaues are : "+res[0]+" , "+res[1]);

    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000,100000};
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < k; i++) {
            int minimumOfList = nums.get(i).get(0);
            int[] toBeAdded = {minimumOfList,0,i};
            max = Math.max(max, minimumOfList);
            pq.add(toBeAdded);
        }
        while (true) {
            int[] min = pq.poll();
            if (res[1] - res[0] > max - min[0]) {
                res[0] = min[0];
                res[1] = max;
            }
            min[1]++;
            List<Integer> currentList = nums.get(min[2]);
            if (min[1] == currentList.size()) {
                break;
            }else {
                min[0] = currentList.get(min[1]);
                max = Math.max(max, currentList.get(min[1]));
                pq.add(min);
            }
        }
        return res;
    }
}
