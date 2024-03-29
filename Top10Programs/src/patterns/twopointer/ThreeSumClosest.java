package patterns.twopointer;


import java.util.Arrays;
/*
    https://leetcode.com/problems/3sum-closest/
    https://www.youtube.com/watch?v=BS7_bRsJFiI
 */
public class ThreeSumClosest {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));// 2
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // O(nlogn)
        int closesetSum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
                if (currSum > target) {
                    end--;
                } else {
                    start++;
                }

                if (Math.abs(currSum - target) < Math.abs(closesetSum - target)) {
                    closesetSum = currSum;
                }
            }
        }
        return closesetSum;
    }
}
