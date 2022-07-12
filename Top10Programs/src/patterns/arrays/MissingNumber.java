package patterns.arrays;
/*
 * https://leetcode.com/problems/missing-number/
 * https://www.youtube.com/watch?v=YRsy-pYAZ30
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1,3};
        System.out.println(missingNumber(nums)); //2
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedTotal = (n*(n+1))/2;
        int total = 0;
        for(int num:nums){
            total += num;
        }

        return expectedTotal-total;
    }
}
