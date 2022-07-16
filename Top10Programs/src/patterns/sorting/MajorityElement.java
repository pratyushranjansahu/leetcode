package patterns.sorting;
/*
    https://leetcode.com/problems/majority-element/
    https://www.youtube.com/watch?v=PUCEWmefFm4
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));//2
    }
    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int i = 1;  i<nums.length; i++) {
            int num = nums[i];
            if (res == num) ++count;
            else --count;

            if (count == 0) {
                res = num;
                count = 1;
            }
        }
        return res;
    }
}
