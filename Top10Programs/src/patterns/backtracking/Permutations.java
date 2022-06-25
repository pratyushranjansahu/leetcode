package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/permutations/
    https://www.youtube.com/watch?v=ewww8VWF-rE&t=396s
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> copyList = new ArrayList();
            for (int num : nums)
                copyList.add(num);
            result.add(copyList);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, result);
            swap(nums, i, index); // backtrack
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
