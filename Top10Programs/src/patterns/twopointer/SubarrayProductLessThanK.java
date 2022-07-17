package patterns.twopointer;
/*
    https://leetcode.com/problems/subarray-product-less-than-k/
    https://www.youtube.com/watch?v=SxtxCSfSGlo
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));// 8
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0)
            return 0;
        int product = 1;
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}
