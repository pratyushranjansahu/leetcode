package patterns.twopointer;

import java.util.HashMap;
import java.util.Map;
/*
    https://leetcode.com/problems/two-sum/
    https://www.youtube.com/watch?v=VbVQJRKXxBA
    https://www.youtube.com/watch?v=TXxwt1eFF98&t=18s
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        for (int n : twoSum(nums,target)) {
            System.out.print(n+" ");//0 1
        }
    }
    private static int[] twoSum(int[] nums,int target) {
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++) {
            int complement=target-nums[i];
            if(map.containsKey(complement)) {
                int i0=map.get(complement);
                result[0]=i0;
                result[1]=i;
                return result;
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
