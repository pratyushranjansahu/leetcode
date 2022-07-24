package patterns.greedy;
/*
    https://leetcode.com/problems/jump-game/
    https://www.youtube.com/watch?v=VkwFhvfa36Q
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums)); // true
    }
    public static boolean canJump(int[] nums) {
        int lastKnownLocation = nums.length - 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (i + nums[i] >= lastKnownLocation) {
                lastKnownLocation = i;
            }
        }
        return lastKnownLocation == 0;
    }
}
