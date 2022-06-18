package patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    https://leetcode.com/problems/subsets/
    https://www.youtube.com/watch?v=1BbeOUkUOak&t=277s
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));//[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subset = new ArrayList();
        dfs(subset,0,nums,new ArrayList());
        return subset;
    }

    static void dfs( List<List<Integer>> subset,int index,int[] nums,List<Integer> current){
        subset.add(new ArrayList(current));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])continue;
            current.add(nums[i]);
            dfs(subset,i+1,nums, current);
            current.remove(current.size()-1);
        }
    }
}
