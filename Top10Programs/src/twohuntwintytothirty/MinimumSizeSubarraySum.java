package twohuntwintytothirty;
/*
    https://leetcode.com/problems/minimum-size-subarray-sum/
    https://www.youtube.com/watch?v=jKF9AcyBZ6E
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));//2
    }
    private static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int valSum = 0;
        for (int i = 0; i < nums.length; i++) {
            valSum += nums[i];
            while (valSum >= target) {
                res = Math.min(res, i - left + 1);
                valSum -= nums[left];
                left++;
            }
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
