package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/combinations/
    https://www.youtube.com/watch?v=fqrOsZdKegQ
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));//[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subset = new ArrayList();
        dfs(subset,1,new ArrayList(),n,k);
        return subset;

    }

    static void dfs( List<List<Integer>> subset,int index,List<Integer> current,int n,int k){

        if(current.size()==k){
            subset.add(new ArrayList(current));
            return;
        }


        for(int i=index;i<=n;i++){
            current.add(i);
            dfs(subset,i+1,current,n,k);
            current.remove(current.size()-1);
        }
    }
}
