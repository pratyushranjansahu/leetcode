package patterns.arrays;

import java.util.Arrays;
/*
    https://leetcode.com/problems/contains-duplicate/
    https://www.youtube.com/watch?v=4oZsPXG9B94
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));// true
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
