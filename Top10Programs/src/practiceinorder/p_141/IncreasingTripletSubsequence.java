package huneightytoninty;
/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * https://www.youtube.com/watch?v=yEFlGWOVH8g
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums));//true
    }
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int in = 0; in < nums.length; in++) {
            if (nums[in] <= i) {
                i = nums[in];
            } else if (nums[in] <= j) {
                j = nums[in];
            } else {
                return true;
            }
        }
        return false;
    }
}
