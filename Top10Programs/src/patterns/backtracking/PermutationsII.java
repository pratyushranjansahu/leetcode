package patterns.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    https://leetcode.com/problems/permutations-ii/
    https://www.youtube.com/watch?v=iCIrAwn2d1g&t=427s
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permute(nums));//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    public static List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        permute(nums, 0, result);
        return new ArrayList<>(result);
    }

    private static void permute(int[] nums, int index, Set<List<Integer>> result) {
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

