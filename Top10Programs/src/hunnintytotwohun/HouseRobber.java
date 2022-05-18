package hunnintytotwohun;
/*
 * https://leetcode.com/problems/house-robber/
 * https://www.youtube.com/watch?v=jzpsHKJy00c&t=309s
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));//4
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int v1 = nums[0], v2 = Math.max(v1,  nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = v2;
            v2 = Math.max(v2, v1 + nums[i]);
            v1 = tmp;
        }
        return v2;
    }
}
