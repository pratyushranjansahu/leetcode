package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/combination-sum
    https://www.youtube.com/watch?v=obBSF4AG3qU
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));//[[2, 2, 3], [7]]
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subset = new ArrayList();
        dfs(subset,0,candidates,new ArrayList(),target);
        return subset;
    }

    static void dfs( List<List<Integer>> subset,int index,int[] candidates,List<Integer> current,int target){

        if(target<0)return;
        if(target==0){
            subset.add(new ArrayList(current));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            current.add(candidates[i]);
            dfs(subset,i,candidates, current,target-candidates[i]);
            current.remove(current.size()-1);
        }
    }
}
