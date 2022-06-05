package twohuntentotwinty;
/*
    https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
    https://www.youtube.com/watch?v=fW37Xe2yMEE
    https://walkccc.me/LeetCode/problems/0995/
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;
        System.out.println(minKBitFlips(nums, k)); //3
    }
    public static int minKBitFlips(int[] A, int K) {
        int ans = 0;
        int flippedTime = 0;

        for (int r = 0; r < A.length; ++r) {
            if (r >= K && A[r - K] == 2)
                --flippedTime;
            if (flippedTime % 2 == A[r]) {
                if (r + K > A.length)
                    return -1;
                ++ans;
                ++flippedTime;
                A[r] = 2;
            }
        }

        return ans;
    }
}
