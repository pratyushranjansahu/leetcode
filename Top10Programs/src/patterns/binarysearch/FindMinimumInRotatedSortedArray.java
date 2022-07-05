package patterns.binarysearch;
/*
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    https://www.youtube.com/watch?v=Kcj2NGnuSNg&t=560s
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));// 1
    }
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums[lo] <= nums[hi]) {
            return nums[0];
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }else if (nums[lo] <= nums[mid]) {
                lo = mid + 1;
            }else if (nums[mid] <= nums[hi]) {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
