package hunnintytotwohun;
/*
 * https://leetcode.com/problems/sort-colors/
 * https://www.youtube.com/watch?v=XOX1WvUMpwQ&t=969s
 */
public class SetColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);//[0,0,1,1,2,2]
    }
    public static void sortColors(int[] nums) {
        int p0 = 0, p = 0, p2 = nums.length-1;
        while (p <= p2) {
            if (nums[p] == 0) {
                nums[p] = nums[p0];
                nums[p0] = 0;
                p0++;
                p++;
            }else if (nums[p] == 2) {
                nums[p] = nums[p2];
                nums[p2] = 2;
                p2--;
            }else {
                p++;
            }
        }
    }

}
