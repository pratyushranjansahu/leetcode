package patterns.arrays;
/*
 * https://leetcode.com/problems/single-number/
 * https://www.youtube.com/watch?v=L2R5pUSeyL8
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));//4
    }

    public static int singleNumber(int[] nums) {

        int xor = 0;

        for (int num : nums) {
            xor = xor ^ num;
        }

        return xor;
    }
}
