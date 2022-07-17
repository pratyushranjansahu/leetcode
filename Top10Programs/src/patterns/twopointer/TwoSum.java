package patterns.twopointer;

import java.util.HashMap;
import java.util.Map;
/*
    https://leetcode.com/problems/two-sum/
    https://www.youtube.com/watch?v=TXxwt1eFF98
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
        HashMap<Integer,Integer> map  = new HashMap();

        //Fill HM
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        //Searching
        for(int i=0;i<nums.length;i++){ //2 7 11 15  target = 4
            int num = nums[i];
            int rem = target - num;
            if(map.containsKey(rem)){
                int index = map.get(rem);
                if(index==i)continue;
                return new int[]{i,index};
            }
        }

        return new int[]{};
    }
}
