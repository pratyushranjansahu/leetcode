package twohunonetoten;
/*
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 * https://www.youtube.com/watch?v=My3pobBPtbA
 */
public class NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        int[] nums = {2,1,4,3};
        int left = 2;
        int right = 3;
        System.out.println(numSubarrayBoundedMax(nums, left, right));//3
    }
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si = 0, ei = 0;
        int n = nums.length;
        int ans = 0;
        int prev = 0;
        while (ei < n) {
            if (left <= nums[ei] && nums[ei] <= right) {
                prev = ei - si +1;
                ans += prev;
            }else if (nums[ei] < left) {
                ans += prev;
            }else {
                si = ei+1;
                prev = 0;
            }
            ei++;
        }
        return ans;
    }
}
