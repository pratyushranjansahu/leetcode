package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/combination-sum-iii
    https://www.youtube.com/watch?v=b_tOVuYhEx4&t=11s
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));//[[1, 2, 4]]

    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> subset = new ArrayList();
        dfs(subset,1,new ArrayList(),k,n);
        return subset;
    }

    static void dfs(List<List<Integer>> subset , int index ,List<Integer> current,int k,int target){

        if(current.size()==k){
            if(target==0){
                subset.add(new ArrayList(current));
            }
            return;
        }

        for(int i = index;i<=9;i++){//1------9
            current.add(i);
            dfs(subset,i+1,current,k,target-i);
            current.remove(current.size()-1);
        }
    }
}
