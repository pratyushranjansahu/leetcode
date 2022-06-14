package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/subsets/
    https://www.youtube.com/watch?v=1BbeOUkUOak&t=277s
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));//
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());

        for(int x : nums) {
            int n=result.size();
            for(int i=0;i<n;i++) {
                List l=new ArrayList<>(result.get(i));
                l.add(x);
                result.add(l);
            }
        }

        return result;
    }
}
