package huneightytoninty;

import java.util.HashMap;
import java.util.Map;
/*
 * https://leetcode.com/problems/4sum-ii/
 * https://www.youtube.com/watch?v=gwcrPfwqCRw&t=580s
 */
public class FourSumII {
    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4)); //2
    }
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap();
        for (int e1 : nums1) {
            for (int e2 : nums2) {
                map.put(e1+e2, map.getOrDefault(e1+e2, 0)+1);
            }
        }

        int target = 0;
        for (int e1 : nums3) {
            for (int e2 : nums4) {
                count += map.getOrDefault(target - (e1+e2), 0);
            }
        }
        return count;
    }

}
