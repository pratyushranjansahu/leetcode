package patterns.arrays;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/find-all-duplicates-in-an-array/
    https://www.youtube.com/watch?v=YoPx8sG_a7E&t=788s
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));//[2, 3]
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            int val = nums[index];
            if (val < 0) {
                res.add(index + 1);
            } else {
                nums[index] *= -1;
            }
        }
        return res;
    }
}
