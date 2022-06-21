package patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    https://leetcode.com/problems/combination-sum-ii
    https://www.youtube.com/watch?v=dvZdWR0sHMk
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));//[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> subset = new ArrayList();
        dfs(subset,0,candidates,new ArrayList(),target);
        return subset;
    }

    static void dfs( List<List<Integer>> subset,int index,int[] candidates,List<Integer> current, int target){

        if(target<0)return;
        if(target==0){
            subset.add(new ArrayList(current));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])continue;
            current.add(candidates[i]);
            dfs(subset,i+1,candidates, current,target-candidates[i]);
            current.remove(current.size()-1);
        }
    }
}
