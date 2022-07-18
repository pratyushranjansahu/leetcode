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
        System.out.println(permuteUnique(nums));//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res ,nums,new ArrayList(),visited);
        return new ArrayList<>(res);
    }

    static void backtrack(Set<List<Integer>> res,int[] nums,List<Integer> curr, boolean[] visited){
        if(curr.size()==nums.length){
            res.add(new ArrayList(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]==true)continue;
            curr.add(nums[i]);
            visited[i] = true;
            backtrack(res,nums, curr,visited);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}

