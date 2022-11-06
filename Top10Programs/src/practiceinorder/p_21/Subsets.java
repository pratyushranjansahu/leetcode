package practiceinorder.p_21;

import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/subsets/
    https://www.youtube.com/watch?v=kYY9DotIKlo&t=6s
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));//
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList();
        dfs(subset, 0, nums, new ArrayList());
        return subset;
    }

    static void dfs(List<List<Integer>> subset, int index, int[] nums, List<Integer> current) {
        subset.add(new ArrayList(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            dfs(subset, i + 1, nums, current);
            current.remove(current.size() - 1);
        }
    }
}