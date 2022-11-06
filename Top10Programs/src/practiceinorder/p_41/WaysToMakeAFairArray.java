package practiceinorder.p_41;
/*
    https://leetcode.com/problems/ways-to-make-a-fair-array/
    https://www.youtube.com/watch?v=s0JtNntehsM
 */
public class WaysToMakeAFairArray {
    public static void main(String[] args) {
        int[] arr = {2,1,6,4};
        System.out.println(waysToMakeFair(arr)); //1
    }
    public static int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                evenSum += nums[i];
            }else {
                oddSum += nums[i];
            }
            odd[i] = oddSum;
            even[i] = evenSum;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                int nos = even[n-1] - nums[0];
                int nes = odd[n-1];
                if (nos == nes)
                    ans++;
                    continue;

            }
            int nes = even[i-1] + odd[n-1]- odd[i];
            int nos = odd[i-1] + even[n-1] - even[i];
            if (nos == nes) {
                ans++;
            }
        }
        return ans;
    }
}
