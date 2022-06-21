package patterns.binarysearch;
/*
    https://leetcode.com/problems/split-array-largest-sum/
    https://www.youtube.com/watch?v=eq6dAJefOqc
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums,m));//18
    }
    public static int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int val : nums) {
            sum += val;
            max = Math.max(val, max);
        }
        int lo = max;
        int hi = sum;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (isPossible(nums, mid, m)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid +1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int[] a, int mid, int m) {
        int sa = 1;
        int sum = 0;
        for (int i = 0; i<a.length; i++) {
            sum += a[i];
            if (sum > mid) {
                sa++;
                sum = a[i];
            }
        }
        return sa <= m;
    }
}
