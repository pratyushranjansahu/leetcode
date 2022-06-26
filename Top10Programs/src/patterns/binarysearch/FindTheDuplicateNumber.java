package patterns.binarysearch;
/*
    https://leetcode.com/problems/find-the-duplicate-number/
    https://www.youtube.com/watch?v=ZrSNH-uGhh8
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));//2
    }
    public static int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){

            if(nums[Math.abs(nums[i])]<0) {
                return Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
            }

        }
        return -1;
    }
}
