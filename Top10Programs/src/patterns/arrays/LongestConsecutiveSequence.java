package patterns.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));//4
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> nums_set = new HashSet<Integer>();
        for(int n : nums) nums_set.add(n);
        int res = 0;
        for(int n : nums){
            if(nums_set.contains(n) ){
                nums_set.remove(n);
                int prev = n-1;
                int next = n+1;
                while(nums_set.contains(prev)) nums_set.remove(prev--);
                while(nums_set.contains(next)) nums_set.remove(next++);
                res = Math.max(res, next-prev-1);
            }
        }
        return res;
    }
}
