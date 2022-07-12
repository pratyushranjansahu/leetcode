package patterns.arrays;

import java.util.ArrayList;
import java.util.List;
/*
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * https://www.youtube.com/watch?v=Y5AkrdnUOxs&t=16s
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                int elementData = i + 1;
                res.add(elementData);
            }
        }
        return res;
    }
}
