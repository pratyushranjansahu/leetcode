package patterns.dynamicprogramming;
/*
 https://leetcode.com/problems/house-robber-ii/description/
 logic is similar to houserubber I
 */
public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));//3
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];  // Only one house, rob it

        // Case 1: Rob from index 0 to n-2
        Integer[] dp1 = new Integer[n];
        int case1 = houseRobber(nums, dp1, 0, n - 2);

        // Case 2: Rob from index 1 to n-1
        Integer[] dp2 = new Integer[n];
        int case2 = houseRobber(nums, dp2, 1, n - 1);

        return Math.max(case1, case2);
    }
    public static int houseRobber(int[] house, Integer[] dp, int currIdx, int endIdx) {
        if (currIdx > endIdx) return 0;

        if (dp[currIdx] != null)
            return dp[currIdx];

        int steal = house[currIdx] + houseRobber(house, dp, currIdx + 2, endIdx);
        int skip = houseRobber(house, dp, currIdx + 1, endIdx);

        return dp[currIdx] = Math.max(steal, skip);
    }
}
