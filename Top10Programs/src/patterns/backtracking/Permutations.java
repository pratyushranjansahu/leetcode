package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/permutations/
    https://www.youtube.com/watch?v=ewww8VWF-rE&t=396s
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> result) {
        // System.out.println("Index is : "+index);
        if (index == nums.length) {
            //System.out.println("Printing value");
            List<Integer> copyList = new ArrayList();
            for (int num : nums)
                copyList.add(num);
            result.add(copyList);
           // System.out.println(result);
            return;
        }

        for (int i = index; i < nums.length; i++) {
           // System.out.println("i value is : "+i+" , index is : "+index);
            swap(nums, i, index);
            permute(nums, index + 1, result);
           // System.out.println("after call i value is : "+i+" , index is : "+index);
            swap(nums, i, index); // backtrack
        }
    }

    private static void swap(int[] nums, int i, int j) {
        //System.out.println("swap between : "+i +" , "+j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res ,nums,new ArrayList(),visited);
        return res;
    }

    static void  backtrack(List<List<Integer>> res,int[] nums,List<Integer> curr, boolean[] visited){
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
    }*/
}

