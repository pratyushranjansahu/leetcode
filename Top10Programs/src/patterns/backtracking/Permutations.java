package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/permutations/
    https://www.youtube.com/watch?v=R3Sm9V2OSCo&t=503s
    https://www.youtube.com/watch?v=ewww8VWF-rE&t=396s
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res ,nums,new ArrayList(),visited);
        return res;
    }

    static void backtrack(List<List<Integer>> res,int[] nums,List<Integer> curr, boolean[] visited){
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

