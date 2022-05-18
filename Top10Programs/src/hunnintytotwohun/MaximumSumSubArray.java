package hunnintytotwohun;
/*
 * https://leetcode.com/problems/maximum-subarray/
 * https://www.youtube.com/watch?v=VMtyGnNcdPw
 * Kadane's Algorithm
 */
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSumSubArray(arr));//6
    }
    private static int maximumSumSubArray(int[] a){
        int currentSum = a[0];
        int overAllSum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (currentSum > 0) {
                currentSum += a[i];
            }else {
                currentSum = a[i];

            }

            if (overAllSum < currentSum) {
                overAllSum = currentSum;
            }
        }
        return overAllSum;
    }
}
