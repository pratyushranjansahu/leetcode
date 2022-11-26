package twohuntentotwinty;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
    https://www.youtube.com/watch?v=fW37Xe2yMEE
    https://walkccc.me/LeetCode/problems/0995/
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
       // int[] nums = {0,0,0,1,0,1,1,0};
        //int k = 3;
        int[] nums = {0,1,0};
        int k = 2;
        System.out.println(minKBitFlips1(nums, k)); //3
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

    public static int minKBitFlips1(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}
