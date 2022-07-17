package patterns.twopointer;
/*
    https://leetcode.com/problems/squares-of-a-sorted-array/
    https://www.youtube.com/watch?v=DC2XkNuSYKU
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] res = sortedSquares(nums);//[0 1 9 16 100]
        for (int v : res) {
            System.out.print(v+" ");
        }
    }
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int beg = 0, end = n - 1, i = n - 1;
        while (i >= 0) {
            if (nums[beg] * nums[beg] > nums[end] * nums[end]) {
                res[i--] = nums[beg] * nums[beg];
                beg++;
            } else {
                res[i--] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }
}
