package patterns.arrays;
/*
    https://leetcode.com/problems/first-missing-positive/
    https://www.youtube.com/watch?v=QeBvfH1dpOU
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));//3
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean isOne = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                isOne = true;
            }
            if (nums[i] < 1 || n < nums[i]) {
                nums[i] = 1;
            }
        }

        if (isOne == false) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            nums[index - 1] = -Math.abs(nums[index - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
