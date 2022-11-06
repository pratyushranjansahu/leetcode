package practiceinorder.p_21;

import java.util.Arrays;
/*
    https://leetcode.com/problems/wiggle-sort-ii/
    https://www.youtube.com/watch?v=mwsjU6CHOb4
 */
public class WiggleSortII {
    public static void main(String[] args) {

    }
    public void wiggleSort(int[] nums) {
        // Sort the Array
        Arrays.sort(nums);
        // Make an extra array
        int n = nums.length;
        int[] res = new int[n];

        int i = 1;
        int j = n-1;

        while (i < n) {
            res[i] = nums [j];
            i += 2;
            j--;
        }
        i = 0;
        while (i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        // Fill i/p array from res
        for (int k = 0; k < n; k++) {
            nums[k] = res[k];
        }
    }
}

